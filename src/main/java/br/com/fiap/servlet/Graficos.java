package br.com.fiap.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import br.com.fiap.bean.Avaliacao;
import br.com.fiap.bean.Paciente;
import br.com.fiap.controller.AvaliacaoController;
import br.com.fiap.controller.PacienteController;

@WebServlet("/graficos")
public class Graficos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private PacienteController pacienteController;
	private AvaliacaoController avaliacaoController;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String acao = request.getParameter("acao");
		
		switch(acao) {
		case "idades":
			idades(request, response);
			break;
		case "notas":
			media_notas(request, response);
			break;
		case "quantidade":
			quantidade_paciente(request, response);
			break;
		case "media":
			media(request, response);
			break;
		case "sexo":
			sexos(request, response);
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	
	private void idades(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			List<Integer> idades = new ArrayList<>();
			for(Paciente p: this.pacienteController.listarPacientes()) {
				idades.add(p.getIdade());
			}
			
			Gson gson = new Gson();
			String idadesJson = gson.toJson(idades);
			
			
			
			response.setContentType("application/json");
			response.getWriter().write(idadesJson);
			
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void media_notas(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.avaliacaoController = new AvaliacaoController();
			List<Integer> notas = new ArrayList<>();
			for(Avaliacao a: this.avaliacaoController.notaParaDashboard()) {
				notas.add(a.getNota());
			}
			 int cont0 = Collections.frequency(notas, 0);
			 int cont1 = Collections.frequency(notas, 1);
		     int cont2 = Collections.frequency(notas, 2);
		     int cont3 = Collections.frequency(notas, 3);
		     int cont4 = Collections.frequency(notas, 4);
		     int cont5 = Collections.frequency(notas, 5);
		     int cont6 = Collections.frequency(notas, 6);
		     int cont7 = Collections.frequency(notas, 7);
		     int cont8 = Collections.frequency(notas, 8);
		     int cont9 = Collections.frequency(notas, 9);
		     int cont10 = Collections.frequency(notas,10);
		     Gson gson = new Gson();
		     int[] numeroIdade = {cont0, cont1, cont2, cont3, cont4, cont5, cont6, cont7, cont8, cont9, cont10};
			 String quantidadeIdadeJson = gson.toJson(numeroIdade);
			 response.setContentType("application/json");
			 response.getWriter().write(quantidadeIdadeJson );
			
			this.avaliacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private void quantidade_paciente(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.pacienteController = new PacienteController();
			List<Paciente> pacientes = this.pacienteController.listarPacientes();
			int quantidade = pacientes.toArray().length;
			Gson gson = new Gson();
			String quantidadeJson = gson.toJson(quantidade);
		
			response.setContentType("application/json");
			response.getWriter().write(quantidadeJson);
			
			this.pacienteController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private void media(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			this.avaliacaoController = new AvaliacaoController();
			List<Integer> notas = new ArrayList<>();
			for(Avaliacao a: this.avaliacaoController.notaParaDashboard()) {
				notas.add(a.getNota());
			}
			
			int soma = calcularSoma(notas);
			double media = ((double) soma)/notas.toArray().length;
		     Gson gson = new Gson();

			String mediaJson = gson.toJson(media);
			 response.setContentType("application/json");
			 response.getWriter().write(mediaJson );
			
			this.avaliacaoController.fecharConexao();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	 private static int calcularSoma(List<Integer> lista) {
	        int soma = 0;

	        for (int numero : lista) {
	            soma += numero;
	        }

	        return soma;
	    }
	 
	 private void sexos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 try {
				this.pacienteController = new PacienteController();
				List<String> sexos = new ArrayList<>();
				for(Paciente p: this.pacienteController.listarPacientes()) {
					sexos.add(p.getSexo());
				}
				
				 int contM = Collections.frequency(sexos, "M");
				 int contF = Collections.frequency(sexos, "F");
			  
			     Gson gson = new Gson();
			     int[] numeroSexos = {contM, contF};
				 String quantidadeSexoJson = gson.toJson(numeroSexos);
				 response.setContentType("application/json");
				 response.getWriter().write(quantidadeSexoJson );
				
				this.pacienteController.fecharConexao();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
	 }
}
