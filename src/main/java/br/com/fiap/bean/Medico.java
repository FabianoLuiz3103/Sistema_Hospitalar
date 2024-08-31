package br.com.fiap.bean;

public class Medico {
	
	private String cod_medico;
	private String nome;
	private String email;
	private String telefone;
	private String crm;
	private String cod_especialidade;
	private String senha;
	
	public Medico() {
		
	}
	
	public Medico(String nome, String email, String telefone, String crm, String cod_especialidade, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.crm = crm;
		this.cod_especialidade = cod_especialidade;
		this.senha = senha;
	}
	
	//Para update
	public Medico(String nome, String email, String telefone,String crm, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.crm = crm;
		this.senha = senha;
	}
	

	public String getCod_medico() {
		return cod_medico;
	}

	public void setCod_medico(String cod_medico) {
		this.cod_medico = cod_medico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getCod_especialidade() {
		return cod_especialidade;
	}

	public void setCod_especialidade(String cod_especialidade) {
		this.cod_especialidade = cod_especialidade;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
	
}
