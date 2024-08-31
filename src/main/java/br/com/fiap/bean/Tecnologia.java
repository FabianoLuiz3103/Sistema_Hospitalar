package br.com.fiap.bean;

import java.util.Date;

public class Tecnologia {
	
	private String cod_tecnologia;
	private String nome;
	private Date data_implementacao;
	
	public Tecnologia() {
		
	}
	
	public Tecnologia(String nome, Date data_implementacao) {
		super();
		this.nome = nome;
		this.data_implementacao = data_implementacao;
	}

	public String getCod_tecnologia() {
		return cod_tecnologia;
	}

	public void setCod_tecnologia(String cod_tecnologia) {
		this.cod_tecnologia = cod_tecnologia;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getData_implementacao() {
		return data_implementacao;
	}

	public void setData_implementacao(Date data_implementacao) {
		this.data_implementacao = data_implementacao;
	}
	
}
