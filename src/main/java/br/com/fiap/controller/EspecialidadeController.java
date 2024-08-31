package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Especialidade;
import br.com.fiap.dao.EspecialidadeDAO;
import br.com.fiap.factory.ConnectionFactory;

public class EspecialidadeController {
	
	private EspecialidadeDAO especialidadeDao;
	
	public EspecialidadeController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.especialidadeDao = new EspecialidadeDAO(conexao);
	}
	
	public List<Especialidade> listarEspecialidades(){
		return this.especialidadeDao.listarEspecialidades();
	}
	
	public List<Especialidade> listaComMedico(){
		return this.especialidadeDao.listaComMedico();
	}
	
	public Especialidade buscarPorCod(String cod) {
		return this.especialidadeDao.buscarPorCod(cod);
	}
	
	public void fecharConexao() {
		this.especialidadeDao.fecharConexao();
	}

}
