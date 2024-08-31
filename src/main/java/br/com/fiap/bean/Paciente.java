package br.com.fiap.bean;

public class Paciente {
	
	private String cod_paciente;
	private String nome;
	private String email;
	private String telefone;
	private String senha;
	private String cpf;
	private int idade;
	private String sexo;
	
	public Paciente(){
		
	}
	
	public Paciente(String nome, String email, String telefone, String senha, String cpf,
			int idade, String sexo) {
		super();
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	
	
	
	

}
