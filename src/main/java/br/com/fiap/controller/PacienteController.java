package br.com.fiap.controller;

import java.sql.Connection;
import java.util.List;

import br.com.fiap.bean.Paciente;
import br.com.fiap.dao.PacienteDAO;
import br.com.fiap.exception.DBException;
import br.com.fiap.factory.ConnectionFactory;

public class PacienteController {
	
	private PacienteDAO pacienteDao;
	
	public PacienteController() throws ClassNotFoundException {
		Connection conexao = new ConnectionFactory().conexao();
		this.pacienteDao = new PacienteDAO(conexao);
	}
	
	public void cadastrarPaciente(Paciente paciente) throws DBException {
		this.pacienteDao.cadastrarPaciente(paciente);
	}
	
	public List<Paciente> listarPacientes(){
		return this.pacienteDao.listarPacientes();
	}
	
	public Paciente dadosPaciente(String cpf) {
		return this.pacienteDao.dadosPaciente(cpf);
	}
	
	public void atualizarCadastro(Paciente paciente, String codigo)throws DBException {
		this.pacienteDao.atualizarCadastro(paciente, codigo);
	}
	
	public boolean buscar(String coluna, String valor) {
		return this.pacienteDao.buscar(coluna, valor);
	}
	
	public boolean buscarUpdate(String coluna, String valor, String cod) {
		return this.pacienteDao.buscarUpdate(coluna, valor, cod);
	}
	
	public boolean validarPaciente(String cpf, String senha)throws DBException {
		return this.pacienteDao.validarPaciente(cpf, senha);
	}
	
	public void alterarSenha(String senha, String cpf) {
        this.pacienteDao.alterarSenha(senha, cpf);
	}
	
	public void fecharConexao() {
		this.pacienteDao.fecharConexao();
	}

}
