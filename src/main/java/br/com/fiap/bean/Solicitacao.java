package br.com.fiap.bean;

import java.util.Date;

public class Solicitacao {
	
	private String cod_solicitacao;
	private String cod_paciente;
	private String nome;
	private String nomeM;
	private String cod_medico;
	private String status;
	private Date data_solicitacao;
	
	public Solicitacao() {
		
	}

	public Solicitacao(String cod_paciente, String cod_medico, String status,
			Date data_solicitacao) {
		super();
		this.cod_paciente = cod_paciente;
		this.cod_medico = cod_medico;
		this.status = status;
		this.data_solicitacao = data_solicitacao;
	}

	public String getCod_solicitacao() {
		return cod_solicitacao;
	}

	public void setCod_solicitacao(String cod_solicitacao) {
		this.cod_solicitacao = cod_solicitacao;
	}

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	public void setNomeM(String nomeM) {
		this.nomeM = nomeM;
	}
	public String getNomeM() {
		return nomeM;
	}

	
	public String getCod_medico() {
		return cod_medico;
	}

	public void setCod_medico(String cod_medico) {
		this.cod_medico = cod_medico;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getData_solicitacao() {
		return data_solicitacao;
	}

	public void setData_solicitacao(Date data_solicitacao) {
		this.data_solicitacao = data_solicitacao;
	}
	

}
