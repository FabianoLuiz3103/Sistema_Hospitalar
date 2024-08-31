package br.com.fiap.bean;

public class Avaliacao {
	
	private String cod_avaliacao;
	private String cod_paciente;
	private String cod_consulta;
	private String pergunta;
	private int nota;
	
	public Avaliacao() {
		
	}

	public String getCod_avaliacao() {
		return cod_avaliacao;
	}

	public void setCod_avaliacao(String cod_avaliacao) {
		this.cod_avaliacao = cod_avaliacao;
	}

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public String getCod_consulta() {
		return cod_consulta;
	}

	public void setCod_consulta(String cod_consulta) {
		this.cod_consulta = cod_consulta;
	}

	public String getPergunta() {
		return pergunta;
	}

	public void setPergunta(String pergunta) {
		this.pergunta = pergunta;
	}

	public int getNota() {
		return nota;
	}

	public void setNota(int nota) {
		this.nota = nota;
	}
	
}
