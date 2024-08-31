package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Medico;
import br.com.fiap.dao.MedicoDAO;
import br.com.fiap.factory.ConnectionFactory;

public class MedicoController {

	private MedicoDAO medicoDao;
	
	public MedicoController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.medicoDao = new MedicoDAO(conexao);
	}
	
	public void cadastrarMedico(Medico medico) {
		this.medicoDao.cadastrarMedico(medico);
	}
	
	public List<Medico> listarPorEspecialidade(String cod_especialidade){
		return this.medicoDao.listarPorEspecialidade(cod_especialidade);
	}
	
	public Medico dadosMedico(String crm){
		return this.medicoDao.dadosMedico(crm);
	}
	
	public void atualizarCadastro(Medico medico, String cod) {
		this.medicoDao.atualizarCadastro(medico, cod);
	}
	
	public void fecharConexao() {
		this.medicoDao.fecharConexao();
	}

	public boolean validarMedico(String crm, String senha) {
		return this.medicoDao.validarMedico(crm, senha);
	}

	public boolean buscar(String coluna, String crm) {
		return this.medicoDao.buscar(coluna, crm);
	}
	
	public boolean buscarUpdate(String coluna, String valor, String cod_medico) {
		return this.medicoDao.buscarUpdate(coluna, valor, cod_medico);
	}
	
	public void alterarSenha(String senha, String crm) {
		this.medicoDao.alterarSenha(senha, crm);
	}
}
