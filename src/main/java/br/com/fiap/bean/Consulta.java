package br.com.fiap.bean;

import java.time.LocalTime;
import java.util.Date;

public class Consulta {
	
	private String cod_consulta;
	private String descricao;
	private String cod_paciente;
	private String cod_medico;
	private String cod_tecnologia;
	private Date data;
	private LocalTime hora;
	
	public Consulta() {
		
	}
	
	public Consulta(String cod_paciente, String cod_medico, String cod_tecnologia, Date data,
			LocalTime hora) {
		super();
		this.cod_paciente = cod_paciente;
		this.cod_medico = cod_medico;
		this.cod_tecnologia = cod_tecnologia;
		this.data = data;
		this.hora = hora;
	}
	
	public Consulta(String descricao, Date data,
			LocalTime hora) {
		super();
		this.descricao = descricao;
		this.data = data;
		this.hora = hora;
	}
	

	public String getCod_consulta() {
		return cod_consulta;
	}

	public void setCod_consulta(String cod_consulta) {
		this.cod_consulta = cod_consulta;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getCod_paciente() {
		return cod_paciente;
	}

	public void setCod_paciente(String cod_paciente) {
		this.cod_paciente = cod_paciente;
	}

	public String getCod_medico() {
		return cod_medico;
	}

	public void setCod_medico(String cod_medico) {
		this.cod_medico = cod_medico;
	}

	public String getCod_tecnologia() {
		return cod_tecnologia;
	}

	public void setCod_tecnologia(String cod_tecnologia) {
		this.cod_tecnologia = cod_tecnologia;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public LocalTime getHora() {
		return hora;
	}

	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	
}
