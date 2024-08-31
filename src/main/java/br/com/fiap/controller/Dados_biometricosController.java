package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Dados_biometricos;
import br.com.fiap.dao.Dados_biometricosDAO;
import br.com.fiap.factory.ConnectionFactory;

public class Dados_biometricosController {

	private Dados_biometricosDAO dadosBiDao;
	
	public Dados_biometricosController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.dadosBiDao = new Dados_biometricosDAO(conexao);
	}
	
	public List<Dados_biometricos> listarResultados(String cod_paciente){
		return this.dadosBiDao.listarResultados(cod_paciente);
	}
	
	public void fecharConexao() {
		this.dadosBiDao.fecharConexao();
	}
}
