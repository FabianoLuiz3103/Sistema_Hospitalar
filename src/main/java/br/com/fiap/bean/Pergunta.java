package br.com.fiap.bean;

public class Pergunta {
	
	private String cod_pergunta;
	private String texto;
	
	public Pergunta() {
		
	}

	public Pergunta(String cod_pergunta, String texto) {
		super();
		this.cod_pergunta = cod_pergunta;
		this.texto = texto;
	}

	public String getCod_pergunta() {
		return cod_pergunta;
	}

	public void setCod_pergunta(String cod_pergunta) {
		this.cod_pergunta = cod_pergunta;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}
	
}
