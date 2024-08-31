package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Consulta;
import br.com.fiap.dao.ConsultaDAO;
import br.com.fiap.factory.ConnectionFactory;

public class ConsultaController {
	
	private ConsultaDAO consultaDao;
	
	public ConsultaController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.consultaDao = new ConsultaDAO(conexao);
	}
	
	public String CadastrarConsulta(Consulta consulta) {
		return this.consultaDao.cadastrarConsulta(consulta);
	}
	
	public List<Consulta> consultasDoPaciente(String cod_paciente){
		return this.consultaDao.consultasDoPaciente(cod_paciente);
	}
	
	public List<Consulta> listarConsultas(){
		return this.consultaDao.listarConsultas();
	}
	
	public Consulta dadosConsulta(String cod_consulta) {
		return this.consultaDao.dadosConsulta(cod_consulta);
	}
	
	public void atualizarConsulta(Consulta consulta) {
		this.consultaDao.atualizarConsulta(consulta);
	}
	
	public void fecharConexao() {
		this.consultaDao.fecharConexao();
	}

}
