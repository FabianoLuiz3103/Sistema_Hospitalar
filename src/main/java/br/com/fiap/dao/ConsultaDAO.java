package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.com.fiap.bean.Consulta;

public class ConsultaDAO {

	private Connection conexao;

	public ConsultaDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public String cadastrarConsulta(Consulta consulta) {
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String idGerado = null;
		String sql = "INSERT INTO consulta (paciente_cod_paciente, medico_cod_medico, tecnologia_cod_tecnologia, data, hora) VALUES (?,?,?,?,?)";
		try {
			// Data consulta/exame
			java.util.Date dataAgendada = consulta.getData();
			java.sql.Date sqlDate = new java.sql.Date(dataAgendada.getTime());
			Instant instant = dataAgendada.toInstant();
			LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
			LocalTime horaLocal = consulta.getHora();
			LocalDateTime localDateTime = LocalDateTime.of(localDate, horaLocal);
			Timestamp horaTimestamp = Timestamp.valueOf(localDateTime);

			pstm = conexao.prepareStatement(sql, new String[]{"cod_consulta"});
			pstm.setString(1, consulta.getCod_paciente());
			pstm.setString(2, consulta.getCod_medico());
			pstm.setString(3, consulta.getCod_tecnologia());
			pstm.setDate(4, sqlDate);
			pstm.setTimestamp(5, horaTimestamp);

			pstm.executeUpdate();
			
			 rst = pstm.getGeneratedKeys();
	            if (rst.next()) {
	                idGerado = rst.getString(1);
	            }

		} catch (SQLException e) {

			e.printStackTrace();
		}finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return idGerado;
	}

	public List<Consulta> consultasDoPaciente(String cod_paciente) {
		List<Consulta> consultas = new ArrayList<Consulta>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM consulta WHERE paciente_cod_paciente = ?";

		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod_paciente);
			rst = pstm.executeQuery();

			while (rst.next()) {
				Consulta cons = new Consulta();
				cons.setCod_consulta(rst.getString("cod_consulta"));
				cons.setCod_paciente(rst.getString("paciente_cod_paciente"));
				cons.setCod_medico(rst.getString("medico_cod_medico"));
				cons.setCod_tecnologia(rst.getString("tecnologia_cod_tecnologia"));
				cons.setData(rst.getDate("data"));
				LocalDateTime localDateTime = rst.getTimestamp("hora").toLocalDateTime();
				LocalTime localTime = localDateTime.toLocalTime();
				// Usando a hora converdida de Timestamp para localtime
				cons.setHora(localTime);

				consultas.add(cons);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return consultas;

	}

	public List<Consulta> listarConsultas() {
		List<Consulta> consultas = new ArrayList<Consulta>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM consulta";

		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();

			while (rst.next()) {
				Consulta cons = new Consulta();
				cons.setCod_consulta(rst.getString("cod_consulta"));
				cons.setCod_paciente(rst.getString("paciente_cod_paciente"));
				cons.setCod_medico(rst.getString("medico_cod_medico"));
				cons.setCod_tecnologia(rst.getString("tecnologia_cod_tecnologia"));
				cons.setData(rst.getDate("data"));
				LocalDateTime localDateTime = rst.getTimestamp("hora").toLocalDateTime();
				LocalTime localTime = localDateTime.toLocalTime();
				cons.setHora(localTime);

				consultas.add(cons);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rst != null) {
					rst.close();
				}
				if (pstm != null) {
					pstm.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return consultas;

	}
	
	public Consulta dadosConsulta(String cod_consulta) {
		PreparedStatement pstm = null;
		ResultSet rst =  null;
		Consulta consulta = null;
		String sql = "SELECT * FROM consulta WHERE cod_consulta = ?";
		
		try {
			pstm = this.conexao.prepareStatement(sql);
			pstm.setString(1, cod_consulta);
			
			rst = pstm.executeQuery();
			while(rst.next()) {
				consulta = new Consulta();
				consulta.setCod_consulta(rst.getString("cod_consulta"));
				consulta.setCod_paciente(rst.getString("paciente_cod_paciente"));
				consulta.setCod_medico(rst.getString("medico_cod_medico"));
				consulta.setCod_tecnologia(rst.getString("tecnologia_cod_tecnologia"));
				consulta.setData(rst.getDate("data"));
				LocalDateTime localDateTime = rst.getTimestamp("hora").toLocalDateTime();
				LocalTime localTime = localDateTime.toLocalTime();
				consulta.setHora(localTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return consulta;
	}

	public void atualizarConsulta(Consulta consulta) {
		PreparedStatement pstm = null;
		String sql = "UPDATE consulta C SET C.descricao = ?, C.data = ?, C.hora = ?";

		try {
			// Data consulta/exame
			java.util.Date dataAgendada = consulta.getData();
			java.sql.Date sqlDate = new java.sql.Date(dataAgendada.getTime());
			// Hora consulta/exame
			LocalTime horaLocal = consulta.getHora();
			Timestamp horaTimestamp = Timestamp.valueOf(horaLocal.atDate(java.time.LocalDate.now()));
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, consulta.getDescricao());
			pstm.setDate(2, sqlDate);
			pstm.setTimestamp(3, horaTimestamp);
			pstm.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void fecharConexao() {
		try {
			if (conexao != null) {
				conexao.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
