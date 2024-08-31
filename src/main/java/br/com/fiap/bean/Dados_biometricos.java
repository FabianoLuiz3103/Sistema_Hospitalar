package br.com.fiap.bean;

import java.util.Date;

public class Dados_biometricos {
	
	private String cod_dados;
	private String cod_consulta;
	private String cod_paciente;
	private String medico;
	private String crm;
	private String especialidade;
	private String tipo_diagnostico;
	private String resultado_exame;
	private double altura;
	private double peso;
	private Date data;
	
	public Dados_biometricos() {
		
	}
	
	public String getCod_dados() {
		return cod_dados;
	}

	public void setCod_dados(String cod_dados) {
		this.cod_dados = cod_dados;
	}
	
	public String getCod_consulta() {
		return cod_consulta;
	}

	public void setCod_consulta(String cod_consulta) {
		this.cod_consulta = cod_consulta;
	}
	
	

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public String getMedico() {
		return medico;
	}

	public void setMedico(String medico) {
		this.medico = medico;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getTipo_diagnostico() {
		return tipo_diagnostico;
	}

	public void setTipo_diagnostico(String tipo_diagnostico) {
		this.tipo_diagnostico = tipo_diagnostico;
	}

	public String getResultado_exame() {
		return resultado_exame;
	}

	public void setResultado_exame(String resultado_exame) {
		this.resultado_exame = resultado_exame;
	}

	public double getAltura() {
		return altura;
	}

	public void setAltura(double altura) {
		this.altura = altura;
	}

	public double getPeso() {
		return peso;
	}

	public void setPeso(double peso) {
		this.peso = peso;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
	
}
