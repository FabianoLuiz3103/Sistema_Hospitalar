package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Avaliacao;

public class AvaliacaoDAO {

	private Connection conexao;
	
	public AvaliacaoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrarNota(String cod_avaliacao, String cod_pergunta, int nota) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO perguntas_notas (avaliacao_cod_avaliacao, perguntas_cod_pergunta, nota) VALUES (?, ?, ?)";

		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod_avaliacao);
			pstm.setString(2, cod_pergunta);
			pstm.setInt(3, nota);
			
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	public String novaAvaliacao(String cod_paciente, String cod_consulta) {
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "INSERT INTO avaliacao (paciente_cod_paciente, consulta_cod_consulta) VALUES (?, ?)";

		String idGerado =  null;
		try {
			pstm = conexao.prepareStatement(sql, new String[]{"cod_avaliacao"});
			pstm.setString(1, cod_paciente);
			pstm.setString(2, cod_consulta);
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
	
	public List<Avaliacao> notaParaDashboard(){
		List<Avaliacao> notas = new ArrayList<Avaliacao>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT p.texto_pergunta, pn.nota FROM avaliacao av LEFT JOIN perguntas_notas pn ON av.cod_avaliacao = pn.avaliacao_cod_avaliacao LEFT JOIN perguntas p ON pn.perguntas_cod_pergunta = p.cod_pergunta";
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Avaliacao av = new Avaliacao();
				av.setNota(rst.getInt("nota"));
				av.setPergunta(rst.getString("texto_pergunta"));
				
				notas.add(av);
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
		 return notas; 
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
