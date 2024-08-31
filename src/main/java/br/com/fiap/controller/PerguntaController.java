package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Pergunta;
import br.com.fiap.dao.PerguntaDao;
import br.com.fiap.factory.ConnectionFactory;

public class PerguntaController {
	
	private PerguntaDao perguntaDao;
	
	public PerguntaController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.perguntaDao = new PerguntaDao(conexao);
	}
	
	public List<Pergunta> listarPerguntas(){
		return this.perguntaDao.carregarPerguntas();
	}
	
	public void fecharConexao() {
		this.perguntaDao.fecharConexao();
	}

}
