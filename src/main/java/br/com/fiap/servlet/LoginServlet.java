package br.com.fiap.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.fiap.bean.Medico;
import br.com.fiap.bean.Paciente;
import br.com.fiap.controller.MedicoController;
import br.com.fiap.controller.PacienteController;
import br.com.fiap.exception.DBException;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PacienteController pacienteController;
	private MedicoController medicoController;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acaoLogout");
		
		switch(acao) {
		
		case "pacienteLogout":
			logoutPaciente(request, response);
			break;
		case "medicoLogout":
			logoutMedico(request, response);
			break;
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String acao = request.getParameter("acaoLogin");
		
		switch(acao) {
		
		case "pacienteLogin":
			loginPaciente(request, response);
			break;
		case "medicoLogin":
			loginMedico(request, response);
			break;
		}
	}
	
	public void loginPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			this.pacienteController = new PacienteController();
			String cpf = request.getParameter("cpf");
			String senha = request.getParameter("senha");
			if(this.pacienteController.validarPaciente(cpf, senha)) {
				HttpSession session = request.getSession();
				Paciente p = this.pacienteController.dadosPaciente(cpf);
				session.setAttribute("dadosPaciente", p);
				session.setAttribute("codPaciente", p.getCod_paciente());
				session.setAttribute("pacienteAutenticado", true);
				request.setAttribute("paciente", p);
				request.getRequestDispatcher("menu-paciente.jsp").forward(request, response);
                
				this.pacienteController.fecharConexao();
			}else {
				request.setAttribute("erroLogin", "Usuário ou senha inválido");
				request.setAttribute("loginInvalido", true);
				request.getRequestDispatcher("login-paciente.jsp").forward(request, response);
			}
			
		} catch (DBException db) {
			db.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logoutPaciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	public void loginMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		try {
			this.medicoController = new MedicoController();
			String crm = request.getParameter("crm");
			String senha = request.getParameter("senha");
			if(this.medicoController.validarMedico(crm, senha)) {
				HttpSession session = request.getSession();
				Medico m = this.medicoController.dadosMedico(crm);
				session.setAttribute("dadosMedico", m);
				session.setAttribute("codMedico", m.getCod_medico());
				session.setAttribute("medicoAutenticado", true);
				request.getRequestDispatcher("menu-medico.jsp").forward(request, response);
				this.medicoController.fecharConexao();
			}else {
				request.setAttribute("erroLogin", "Usuário ou senha inválido");
				request.setAttribute("loginInvalido", true);
				request.getRequestDispatcher("login-medico.jsp").forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logoutMedico(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		HttpSession session = request.getSession();
		session.invalidate();
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}
	
	

}
