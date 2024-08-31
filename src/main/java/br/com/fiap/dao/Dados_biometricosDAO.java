package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Dados_biometricos;

public class Dados_biometricosDAO {

	private Connection conexao;

	public Dados_biometricosDAO(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Dados_biometricos> listarResultados(String cod_paciente) {
		List<Dados_biometricos> resultados = new ArrayList<Dados_biometricos>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT pa.cod_paciente, co.cod_consulta, di.cod_diagnostico, di.tipo_diagnostico, dr.result_exame, " +
			    "MAX(db.peso) AS peso, MAX(db.altura) AS altura, MAX(co.data) AS data, MAX(db.cod_dados) AS cod_dados, " +
			    "MAX(me.nome_med) AS nome_med, MAX(me.crm) AS crm, MAX(es.nome_espec) AS nome_espec " +
			    "FROM paciente pa " +
			    "JOIN consulta co ON pa.cod_paciente = co.paciente_cod_paciente " +
			    "JOIN medico me ON co.medico_cod_medico = me.cod_medico " +
			    "JOIN especialidade es ON me.cod_especialidade = es.cod_especialidade " +
			    "JOIN dados_biometricos db ON pa.cod_paciente = db.paciente_cod_paciente " +
			    "LEFT JOIN (SELECT sub_db.paciente_cod_paciente, sub_dr.cod_consulta, sub_dr.dados_biometricos_cod_dados, " +
			    "sub_dr.diagnostico_cod_diagnostico, MAX(sub_dr.result_exame) AS result_exame " +
			    "FROM diagnosticos_resultado sub_dr " +
			    "JOIN dados_biometricos sub_db ON sub_dr.dados_biometricos_cod_dados = sub_db.cod_dados " +
			    "WHERE sub_dr.result_exame IS NOT NULL " +
			    "GROUP BY sub_db.paciente_cod_paciente, sub_dr.cod_consulta, sub_dr.dados_biometricos_cod_dados, " +
			    "sub_dr.diagnostico_cod_diagnostico) dr ON pa.cod_paciente = dr.paciente_cod_paciente " +
			    "AND co.cod_consulta = dr.cod_consulta AND db.cod_dados = dr.dados_biometricos_cod_dados " +
			    "LEFT JOIN diagnostico di ON di.cod_diagnostico = dr.diagnostico_cod_diagnostico " +
			    "WHERE pa.cod_paciente = ? " +
			    "GROUP BY pa.cod_paciente, co.cod_consulta, di.cod_diagnostico, di.tipo_diagnostico, dr.result_exame " +
			    "HAVING MAX(dr.result_exame) IS NOT NULL " +
			    "ORDER BY cod_consulta, cod_diagnostico";



		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod_paciente);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Dados_biometricos db = new Dados_biometricos();
			    db.setCod_paciente(rst.getString("cod_paciente"));
			    db.setMedico(rst.getString("nome_med"));
			    db.setCrm(rst.getString("crm"));
			    db.setEspecialidade(rst.getString("nome_espec"));  
			    db.setTipo_diagnostico(rst.getString("tipo_diagnostico"));
			    db.setResultado_exame(rst.getString("result_exame"));
			    db.setPeso(rst.getDouble("peso"));
			    db.setAltura(rst.getDouble("altura"));
			    db.setData(rst.getDate("data"));
			    db.setCod_dados(rst.getString("cod_dados"));
			    db.setCod_consulta(rst.getString("cod_consulta"));

			    resultados.add(db);
				
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
		return resultados;
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
