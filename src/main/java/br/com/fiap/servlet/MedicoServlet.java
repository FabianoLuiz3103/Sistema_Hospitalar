package br.com.fiap.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.Especialidade;
import br.com.fiap.bean.Medico;
import br.com.fiap.bean.Solicitacao;
import br.com.fiap.controller.ConsultaController;
import br.com.fiap.controller.EspecialidadeController;
import br.com.fiap.controller.MedicoController;
import br.com.fiap.controller.SolicitacaoController;


@WebServlet("/medico")
public class MedicoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private MedicoController medicoController;
    private EspecialidadeController especialidadeController;
    private SolicitacaoController solicitacaoController;
    private boolean bool;
    private String crm_alt;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");

		switch (acao) {
		case "abrir-form-cadastro":
			abrirFormCadastro(request, response);
			break;
		case "abrir-form-edicao":
			abrirFormEdicao(request, response);
			break;
		case "solicitacoes":
			carregarSolicitacoes(request, response);
			break;
		case "abrir-form-login":
			abrirFormLogin(request, response);
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acao");

		switch (acao) {
		case "verifica-crm":
			crm(request, response);
			break;
		case "altera-senha":
			altera_senha(request, response);
			break;
		case "cadastrar":
			cadastrar(request, response);
			break;
		case "editar":
			editar(request, response);
			break;
		case "resposta-solicitacao":
			respostaSolicitacao(request, response);
			break;
		
	
		}
	}
	
	
	private void carregarSolicitacoes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.solicitacaoController = new SolicitacaoController();
			HttpSession session = request.getSession();
			List<Solicitacao> solicitacoes = this.solicitacaoController.listaSolicitacaoMedico((String)session.getAttribute("codMedico"));
			request.setAttribute("solicitacoes", solicitacoes);
			request.getRequestDispatcher("solicitacoes-medico.jsp").forward(request, response);
			this.solicitacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void respostaSolicitacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.solicitacaoController = new SolicitacaoController();
			String cod_solicitacao = request.getParameter("cod_solicitacao");
			String status = request.getParameter("status");
			this.solicitacaoController.atualizaStatus(cod_solicitacao, status);
			this.solicitacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		carregarSolicitacoes(request, response);
	}
	
	private void editar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.medicoController = new MedicoController();
			String cod_medico = request.getParameter("cod_medico");
			String nome = request.getParameter("nome_med");
			String email = request.getParameter("email_med");
			String telefone = request.getParameter("telefone_med");
			String crm = request.getParameter("crm");
			String senha = request.getParameter("senha");
			boolean exEmail = false, exTelefone = false, exCrm = false;
			
			if (verificarEmailUpdate(email, this.medicoController, cod_medico)){
				exEmail = false;
			} else {
				exEmail = verificarEmail(email, this.medicoController);
			}
			if (verificarTelefoneUpdate(telefone, this.medicoController, cod_medico)){
				exTelefone = false;
			} else {
				exTelefone = verificarTelefone(telefone, this.medicoController);
			}
			if (verificarCrmUpdate(crm, this.medicoController, cod_medico)){
				exCrm = false;
			} else {
				exCrm = verificarCrm(crm, this.medicoController);
			}
			
			if(exEmail || exTelefone || exCrm) {
				request.setAttribute("erroUpdate", true);
				if (exEmail) {
					request.setAttribute("erroEmail", "Erro! O e-mail já está em uso!");
					request.setAttribute("emailInvalido", true);
				}
				if (exTelefone) {
					request.setAttribute("erroTelefone", "Erro! O telefone já está em uso!");
					request.setAttribute("telefoneInvalido", true);
				}
				if (exCrm) {
					request.setAttribute("erroCpf", "Erro! O crm já está em uso!");
					request.setAttribute("cpfInvalido", true);
				}
			} else {
				Medico medico = new Medico(nome, email, telefone, crm, senha);
				this.medicoController.atualizarCadastro(medico, cod_medico);
				request.setAttribute("sucessoUpdate", true);
			}

			this.medicoController.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		abrirFormEdicao(request, response);
	}
	
	private void abrirFormEdicao(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.medicoController = new MedicoController();
			String cod_medico = request.getParameter("cod_medico");
			Medico medico = medicoController.dadosMedico(cod_medico);
			request.setAttribute("medico", medico);
			request.getRequestDispatcher("update-medico.jsp").forward(request, response);
			this.medicoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	
	private void cadastrar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.medicoController = new MedicoController();
			String nome = request.getParameter("nome_med");
			String email = request.getParameter("email_med");
			String telefone = request.getParameter("telefone_med");
			String crm = request.getParameter("crm");
			String especialidade = request.getParameter("especialidade");
			String senha = request.getParameter("senha");

			if (verificarEmail(email, this.medicoController) || verificarTelefone(telefone, this.medicoController) || verificarCrm(crm, this.medicoController)) {
				if (verificarEmail(email, this.medicoController)) {
					request.setAttribute("erroEmail", "Erro! O e-mail já está em uso!");
					request.setAttribute("emailInvalido", true);
				}
				if (verificarTelefone(telefone, this.medicoController)) {
					request.setAttribute("erroTelefone", "Erro! O telefone já está em uso!");
					request.setAttribute("telefoneInvalido", true);
				}
				if (verificarCrm(crm, this.medicoController)) {
					request.setAttribute("erroCpf", "Erro! O crm já está em uso!");
					request.setAttribute("cpfInvalido", true);
				}
				abrirFormCadastro(request, response);
			} else {
				Medico medico = new Medico(nome, email, telefone, crm, especialidade, senha);
				this.medicoController.cadastrarMedico(medico);
				request.setAttribute("cadastroSucesso", true);
			}
			this.medicoController.fecharConexao();
		} catch (Exception e) {
			e.printStackTrace();
		}
		abrirFormLogin(request, response);
	}
	
	private void abrirFormCadastro(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		carregarEspecialidades(request);
		request.getRequestDispatcher("cadastro-medico.jsp").forward(request, response);
	}
	
	private void abrirFormLogin(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login-medico.jsp").forward(request, response);
	}
	
	private void carregarEspecialidades(HttpServletRequest request) {
		try {
			this.especialidadeController = new EspecialidadeController();
			List<Especialidade> especialidades = this.especialidadeController.listarEspecialidades();
			request.setAttribute("especialidades", especialidades);
			this.especialidadeController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	private void crm(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.medicoController = new MedicoController();
			String crm = request.getParameter("crmS");
			if(verificarCrm(crm, medicoController)) {
				this.crm_alt = crm;
				request.setAttribute("crmValid", true);
			}else {
				request.setAttribute("crmInvalid", true);
				request.setAttribute("crmMsg", "Erro! O crm informado é inválido!");
				
			}
			this.medicoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("login-medico.jsp").forward(request, response);
	}
	
	private void altera_senha(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			this.medicoController = new MedicoController();
			String senha = request.getParameter("senhaS");
			this.medicoController.alterarSenha(senha, this.crm_alt);
			request.setAttribute("senhaValid", true);
			request.getRequestDispatcher("login-medico.jsp").forward(request, response);;
			this.medicoController.fecharConexao();
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private boolean verificarCrm(String crm, MedicoController med) {
		this.bool = med.buscar("crm", crm);
		return this.bool;
	}
	
	// se email já existe return true
		private boolean verificarEmail(String email, MedicoController med) {
			this.bool = med.buscar("email_med", email);
			return this.bool;
		}

		// se telefone já existe return true
		private boolean verificarTelefone(String telefone, MedicoController med) {
			this.bool = med.buscar("telefone_med", telefone);
			return this.bool;
		}


		// se email já existe e for igual ao do campo return true
		private boolean verificarEmailUpdate(String email, MedicoController med, String cod) {
			this.bool = med.buscarUpdate("email_med", email, cod);
			return this.bool;
		}

		// se telefone já existe e for igual ao do campo return true
		private boolean verificarTelefoneUpdate(String telefone, MedicoController med, String cod) {
			this.bool = med.buscarUpdate("telefone_pac", telefone, cod);
			return this.bool;
		}
		
		private boolean verificarCrmUpdate(String crm, MedicoController med, String cod) {
			this.bool = med.buscarUpdate("crm", crm, cod);
			return this.bool;
		}


}
