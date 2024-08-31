package br.com.fiap.bean;

import java.util.ArrayList;
import java.util.List;

public class Especialidade {
	
	private String cod_especialidade;
	private String nome;
	private List<Medico> medicos = new ArrayList<Medico>();
	
	public Especialidade() {
		
	}

	public String getCod_especialidade() {
		return cod_especialidade;
	}

	public void setCod_especialidade(String cod_especialidade) {
		this.cod_especialidade = cod_especialidade;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Medico> getMedicos() {
		return medicos;
	}

	public void adicionarMedico(Medico medico) {
		medicos.add(medico);
	}

}
