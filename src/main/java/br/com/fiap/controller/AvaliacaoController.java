package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Avaliacao;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.factory.ConnectionFactory;

public class AvaliacaoController {
	
	private AvaliacaoDAO avaliacaoDao;
	
	public AvaliacaoController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.avaliacaoDao = new AvaliacaoDAO(conexao);
	}
	
	public void CadastrarNota(String cod_avaliacao, String cod_pergunta, int nota) {
		this.avaliacaoDao.cadastrarNota(cod_avaliacao, cod_pergunta, nota);
	}
	
	public String novaAvaliacao(String cod_paciente, String cod_consulta) {
		return this.avaliacaoDao.novaAvaliacao(cod_paciente, cod_consulta);
	}
	
	public List<Avaliacao> notaParaDashboard(){
		return this.avaliacaoDao.notaParaDashboard();
	}
	
	public void fecharConexao() {
		this.avaliacaoDao.fecharConexao();
	}

}
