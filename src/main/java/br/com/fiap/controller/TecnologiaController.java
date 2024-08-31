package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Tecnologia;
import br.com.fiap.dao.TecnologiaDAO;
import br.com.fiap.factory.ConnectionFactory;

public class TecnologiaController {
	
	private TecnologiaDAO tecnologiaDao;
	
	public TecnologiaController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.tecnologiaDao = new TecnologiaDAO(conexao);
	}
	
	public List<Tecnologia> listarTecnologias(){
		return this.tecnologiaDao.listarTecnologias();
	}
	
	public void fecharConexao() {
		this.tecnologiaDao.fecharConexao();
	}

}
