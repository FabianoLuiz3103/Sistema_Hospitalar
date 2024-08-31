package br.com.fiap.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import br.com.fiap.bean.Consulta;
import br.com.fiap.bean.Dados_biometricos;
import br.com.fiap.bean.Especialidade;
import br.com.fiap.bean.Medico;
import br.com.fiap.bean.Paciente;
import br.com.fiap.bean.Pergunta;
import br.com.fiap.bean.Solicitacao;
import br.com.fiap.controller.AvaliacaoController;
import br.com.fiap.controller.ConsultaController;
import br.com.fiap.controller.Dados_biometricosController;
import br.com.fiap.controller.EspecialidadeController;
import br.com.fiap.controller.MedicoController;
import br.com.fiap.controller.PacienteController;
import br.com.fiap.controller.PerguntaController;
import br.com.fiap.controller.SolicitacaoController;
import br.com.fiap.exception.DBException;

/**
 * Servlet implementation class PacienteServlet
 */
@WebServlet("/paciente")
public class PacienteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private PacienteController pacienteController;
	private EspecialidadeController especialidadeController;
	private SolicitacaoController solicitacaoController;
	private ConsultaController consultaController;
	private MedicoController medicoController;
	private Dados_biometricosController biometricosController;
	private PerguntaController perguntaController;
	private AvaliacaoController avaliacaoController;
	private Solicitacao soli;
	private boolean bool;
	private String cpf_alt, id_gerado;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		switch (acao) {
		case "listar":
			listar(request, response);
			break;
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		case "agendar":
			listar_especialidade(request, response);
			break;
		case "biometricos":
			dadosBiometricos(request, response);
			break;
		case "carregar-perguntas":
			carregarPerguntas(request, response);
			break;
		case "editar-paciente":
			carregarDados_edicao(request, response);
			break;
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String acao = request.getParameter("acao");

		switch (acao) {
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "verifica-cpf":
			cpf(request, response);
			break;
		case "altera-senha":
			altera_senha(request, response);
			break;
		case "criar-solicitacao":
			criarSolicitacao(request, response);
			break;
		case "fazer-agendamento":
			fazerAgendamento(request, response);
			break;
		case "avaliacao":
			avaliacao(request, response);
			break;
		}
	}

	// métodos
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String nome = request.getParameter("nome_pac");
			String email = request.getParameter("email_pac");
			String telefone = request.getParameter("telefone_pac");
			String cpf = request.getParameter("cpf");
			int idade = Integer.parseInt(request.getParameter("idade"));
			String sexo = request.getParameter("sexo");
			String senha = request.getParameter("senha");

			if (verificarEmail(email, this.pacienteController) || verificarTelefone(telefone, this.pacienteController) || verificarCpf(cpf, this.pacienteController)) {
				if (verificarEmail(email, this.pacienteController)) {
					request.setAttribute("erroEmail", "Erro! O e-mail já está em uso!");
					request.setAttribute("emailInvalido", true);
				}
				if (verificarTelefone(telefone, this.pacienteController)) {
					request.setAttribute("erroTelefone", "Erro! O telefone já está em uso!");
					request.setAttribute("telefoneInvalido", true);
				}
				if (verificarCpf(cpf, this.pacienteController)) {
					request.setAttribute("erroCpf", "Erro! O cpf já está em uso!");
					request.setAttribute("cpfInvalido", true);
				}
				abrirFormCadastro(request, response);
			} else {
				Paciente paciente = new Paciente(nome, email, telefone, senha, cpf, idade, sexo);
				this.pacienteController.cadastrarPaciente(paciente);
				request.setAttribute("cadastroSucesso", true);
				request.getRequestDispatcher("/login-paciente.jsp").forward(request, response);
			}
			this.pacienteController.fecharConexao();
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao cadastrar!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void listar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			List<Paciente> lista = this.pacienteController.listarPacientes();
			request.setAttribute("pacientesLista", lista);
			request.getRequestDispatcher("lista-pacientes.jsp").forward(request, response);
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void dadosPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String cpf = request.getParameter("cpf");
			Paciente paciente = this.pacienteController.dadosPaciente(cpf);
			request.setAttribute("dadosPaciente", paciente);
			request.getRequestDispatcher("menu-paciente.jsp").forward(request, response);
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String cod_paciente = request.getParameter("cod_paciente");
			String nome = request.getParameter("nome_pac");
			String email = request.getParameter("email_pac");
			String telefone = request.getParameter("telefone_pac");
			String cpf = request.getParameter("cpf");
			int idade = Integer.parseInt(request.getParameter("idade"));
			String sexo = request.getParameter("sexo");
			String senha = request.getParameter("senha");
			boolean exEmail = false, exTelefone = false, exCpf = false;
			
			if (verificarEmailUpdate(email, this.pacienteController, cod_paciente)){
				exEmail = false;
			} else {
				exEmail = verificarEmail(email, this.pacienteController);
			}
			if (verificarTelefoneUpdate(telefone, this.pacienteController, cod_paciente)){
				exTelefone = false;
			} else {
				exTelefone = verificarTelefone(telefone, this.pacienteController);
			}
			if (verificarCpfUpdate(cpf, this.pacienteController, cod_paciente)){
				exCpf = false;
			} else {
				exCpf = verificarCpf(cpf, this.pacienteController);
			}
			
			if(exEmail || exTelefone || exCpf) {
				request.setAttribute("erroUpdate", true);
				if (exEmail) {
					request.setAttribute("erroEmail", "Erro! O e-mail já está em uso!");
					request.setAttribute("emailInvalido", true);
				}
				if (exTelefone) {
					request.setAttribute("erroTelefone", "Erro! O telefone já está em uso!");
					request.setAttribute("telefoneInvalido", true);
				}
				if (exCpf) {
					request.setAttribute("erroCpf", "Erro! O cpf já está em uso!");
					request.setAttribute("cpfInvalido", true);
				}
			} else {
				Paciente paciente = new Paciente(nome, email, telefone, senha, cpf, idade, sexo);
				this.pacienteController.atualizarCadastro(paciente, cod_paciente);
				request.setAttribute("sucessoUpdate", true);
			}

			this.pacienteController.fecharConexao();
		} catch (DBException db) {
			db.printStackTrace();
			request.setAttribute("erro", "Erro ao atualizar!");
		} catch (Exception e) {
			e.printStackTrace();
		}
		abrirFormEdicao(request, response);
	}

	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("cadastro-paciente.jsp").forward(request, response);
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String cod_paciente = request.getParameter("cod_paciente");
			Paciente paciente = pacienteController.dadosPaciente(cod_paciente);
			request.setAttribute("paciente", paciente);
			request.getRequestDispatcher("update-paciente.jsp").forward(request, response);
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void cpf(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String cpf = request.getParameter("cpfS");
			if(verificarCpf(cpf, pacienteController)) {
				this.cpf_alt = cpf;
				request.setAttribute("cpfValid", true);
			}else {
				request.setAttribute("cpfInvalid", true);
				request.setAttribute("cpfMsg", "Erro! O cpf informado é inválido!");
			}
			request.getRequestDispatcher("login-paciente.jsp").forward(request, response);
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void altera_senha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			String senha = request.getParameter("senhaS");
			this.pacienteController.alterarSenha(senha, this.cpf_alt);
			request.setAttribute("senhaValid", true);
			request.getRequestDispatcher("login-paciente.jsp").forward(request, response);;
			this.pacienteController.fecharConexao();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void criarSolicitacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cod_paciente = request.getParameter("cod_paciente");
		String cod_medico = request.getParameter("cod_medico");
		String status = request.getParameter("status");
		Date data = new Date();
		String idGerado = null;
		try {
			this.solicitacaoController = new SolicitacaoController();
			Solicitacao soli = new Solicitacao(cod_paciente, cod_medico, status, data);
			idGerado = this.solicitacaoController.criarSolicitacao(soli);
		    this.id_gerado = idGerado;
		   
			this.solicitacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		listar_especialidade(request, response);
		
	}

	
    private void listar_especialidade(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    	String cod = request.getParameter("especialidade");
				try {
					this.especialidadeController = new EspecialidadeController();
					List<Especialidade> lista = this.especialidadeController.listaComMedico();
					String nomeEsp = this.especialidadeController.buscarPorCod(cod).getNome();
					this.solicitacaoController = new SolicitacaoController();
					HttpSession session = request.getSession();
					List<Solicitacao> listaS = this.solicitacaoController.listaSolicitacaoPaciente((String)session.getAttribute("codPaciente"));
					request.setAttribute("especialidades", lista);
					request.setAttribute("codSelecionado", cod);
					request.setAttribute("nomeEsp", nomeEsp);
					request.setAttribute("solicitacao", listaS);
					String status = this.solicitacaoController.retornarStatus(this.id_gerado);
					request.setAttribute("status", status);

						Solicitacao s = this.solicitacaoController.retornaSolicitacao(this.id_gerado);
						this.soli = s;
						
						request.getRequestDispatcher("solicitacao-paciente.jsp").forward(request, response);;
					this.especialidadeController.fecharConexao();
					this.solicitacaoController.fecharConexao();
				}catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
			}
    
    private void fazerAgendamento(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cod_paciente = this.soli.getCod_paciente();
        System.out.println("this soli"  + cod_paciente);
        String cod_medico = this.soli.getCod_medico();
        String dataString = request.getParameter("data");
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date data = null;
        LocalTime localTime = null;
        try {
            data = dateFormat.parse(dataString);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        String horaString = request.getParameter("horario").trim();
        System.out.println("Hora recebida do formulário: " + horaString);
        SimpleDateFormat horaFormat = new SimpleDateFormat("HH:mm");
        System.out.println(horaFormat);
   

        try {
            localTime = LocalTime.parse(horaString);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            this.consultaController = new ConsultaController();
            this.pacienteController = new PacienteController();
            this.medicoController = new MedicoController();
            this.especialidadeController = new EspecialidadeController();
            Consulta consulta = new Consulta(cod_paciente, cod_medico, "T0001", data, localTime);
            String cod_con = this.consultaController.CadastrarConsulta(consulta);
            Consulta c = this.consultaController.dadosConsulta(cod_con);
            Paciente p = this.pacienteController.dadosPaciente(cod_paciente);
            Medico m = this.medicoController.dadosMedico(cod_medico);
            Especialidade e = this.especialidadeController.buscarPorCod(m.getCod_especialidade());
            request.setAttribute("dadosConsulta", c);
            request.setAttribute("dadosPaciente", p);
            request.setAttribute("dadosMedico", m);
            request.setAttribute("dadosEspecialidade", e);
            request.setAttribute("sucessoAgendamento", true);
            request.getRequestDispatcher("confirmacao-agendamento.jsp").forward(request, response);
            this.consultaController.fecharConexao();
            this.pacienteController.fecharConexao();
            this.medicoController.fecharConexao();
            this.especialidadeController.fecharConexao();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    
    private void dadosBiometricos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String cod_paciente = request.getParameter("cod_paciente");
    	try {
			this.biometricosController = new Dados_biometricosController();
			List<Dados_biometricos> lista = this.biometricosController.listarResultados(cod_paciente);
			request.setAttribute("biometricos", lista);
			System.out.println(lista);
			request.getRequestDispatcher("dados-biometricos.jsp").forward(request, response);
			this.biometricosController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
    
    private void carregarPerguntas(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String cod_paciente = request.getParameter("cod_paciente");
    	System.out.println("pac" + cod_paciente);
    	String cod_consulta = request.getParameter("cod_consulta");
    	try {
			this.perguntaController = new PerguntaController();
			this.avaliacaoController = new AvaliacaoController();
			List<Pergunta> perguntas = this.perguntaController.listarPerguntas();
			String idAvaliacao = this.avaliacaoController.novaAvaliacao(cod_paciente, cod_consulta);
			System.out.println(idAvaliacao);
			
			
			 JsonObject jsonResponse = new JsonObject();
			    jsonResponse.add("perguntas", new Gson().toJsonTree(perguntas));
			    jsonResponse.addProperty("idAvaliacao", idAvaliacao);
  
			    response.setContentType("application/json");
			    response.setCharacterEncoding("UTF-8");

			    response.getWriter().write(jsonResponse.toString());
			this.perguntaController.fecharConexao();
			this.avaliacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
    
    private void carregarDados_edicao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	String cod = request.getParameter("cod_paciente");
    	try {
			this.pacienteController = new PacienteController();
			Paciente p = this.pacienteController.dadosPaciente(cod);
			request.setAttribute("paciente", p);
			request.getRequestDispatcher("update-paciente.jsp").forward(request, response);
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    	
    }
    
    private void avaliacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	int nota1 = Integer.parseInt(request.getParameter("nota1"));
    	int nota2 = Integer.parseInt(request.getParameter("nota2"));
    	int nota3 = Integer.parseInt(request.getParameter("nota3"));
    	int nota4 = Integer.parseInt(request.getParameter("nota4"));
    	int nota5 = Integer.parseInt(request.getParameter("nota5"));
    	int nota6 = Integer.parseInt(request.getParameter("nota6"));
    	int nota7 = Integer.parseInt(request.getParameter("nota7"));
    	int nota8 = Integer.parseInt(request.getParameter("nota8"));
    	int nota9 = Integer.parseInt(request.getParameter("nota9"));
    	int nota10 = Integer.parseInt(request.getParameter("nota10"));
    	
    	String pergunta1 = request.getParameter("cod_pergunta1");
    	String pergunta2 = request.getParameter("cod_pergunta2");
    	String pergunta3 = request.getParameter("cod_pergunta3");
    	String pergunta4 = request.getParameter("cod_pergunta4");
    	String pergunta5 = request.getParameter("cod_pergunta5");
    	String pergunta6 = request.getParameter("cod_pergunta6");
    	String pergunta7 = request.getParameter("cod_pergunta7");
    	String pergunta8 = request.getParameter("cod_pergunta8");
    	String pergunta9 = request.getParameter("cod_pergunta9");
    	String pergunta10 = request.getParameter("cod_pergunta10");
    	
    	String avaliacao = request.getParameter("cod_avaliacao");
    	request.getRequestDispatcher("sucesso-avaliacao.jsp").forward(request, response);
    	
    	try {
			this.avaliacaoController = new AvaliacaoController();
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta1, nota1);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta2, nota2);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta3, nota3);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta4, nota4);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta5, nota5);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta6, nota6);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta7, nota7);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta8, nota8);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta9, nota9);
			this.avaliacaoController.CadastrarNota(avaliacao, pergunta10, nota10);
			
			this.avaliacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }


	// se email já existe return true
	private boolean verificarEmail(String email, PacienteController pac) {
		this.bool = pac.buscar("email_pac", email);
		return this.bool;
	}

	// se telefone já existe return true
	private boolean verificarTelefone(String telefone, PacienteController pac) {
		this.bool = pac.buscar("telefone_pac", telefone);
		return this.bool;
	}

	// se cpf já existe return true
	private boolean verificarCpf(String cpf, PacienteController pac) {
		this.bool = pac.buscar("cpf", cpf);
		return this.bool;
	}

	// se email já existe e for igual ao do campo return true
	private boolean verificarEmailUpdate(String email, PacienteController pac, String cod) {
		this.bool = pac.buscarUpdate("email_pac", email, cod);
		return this.bool;
	}

	// se telefone já existe e for igual ao do campo return true
	private boolean verificarTelefoneUpdate(String telefone, PacienteController pac, String cod) {
		this.bool = pac.buscarUpdate("telefone_pac", telefone, cod);
		return this.bool;
	}

	// se cpf já existe e for igual ao do campo return true
	private boolean verificarCpfUpdate(String cpf, PacienteController pac, String cod) {
		this.bool = pac.buscarUpdate("cpf", cpf, cod);
		return this.bool;
	}
}
