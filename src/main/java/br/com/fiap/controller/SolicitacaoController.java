package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Solicitacao;
import br.com.fiap.dao.SolicitacaoDAO;
import br.com.fiap.factory.ConnectionFactory;

public class SolicitacaoController {
	
	private SolicitacaoDAO solicitacaoDao;
	
	public SolicitacaoController()  throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.solicitacaoDao = new SolicitacaoDAO(conexao);
	}
	
	public String criarSolicitacao(Solicitacao solicitacao) {
		return this.solicitacaoDao.criarConexao(solicitacao);
	}
	
	public String retornarStatus(String cod) {
		return this.solicitacaoDao.retornarStatus(cod);
	}
	
	public Solicitacao retornaSolicitacao(String cod) {
		return this.solicitacaoDao.retornarSolicitacao(cod);
	}
	
	public List<Solicitacao> listaSolicitacao(){
			return this.solicitacaoDao.listaSolicitacao();
	}
	
	public List<Solicitacao> listaSolicitacaoMedico(String cod){
		return this.solicitacaoDao.listaSolicitacaoMedico(cod);
	}
	public List<Solicitacao> listaSolicitacaoPaciente(String cod){
		return this.solicitacaoDao.listaSolicitacaoPaciente(cod);
	}
	public void atualizaStatus(String cod_solicitacao, String status) {
		this.solicitacaoDao.atualizaStatus(cod_solicitacao, status);
	}
	
	public void fecharConexao() {
		this.solicitacaoDao.fecharConexao();
	}

}
