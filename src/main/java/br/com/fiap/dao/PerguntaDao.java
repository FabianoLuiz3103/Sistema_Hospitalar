package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Pergunta;

public class PerguntaDao {
	
	private Connection conexao;
	
	public PerguntaDao(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<Pergunta> carregarPerguntas() {
		List<Pergunta> lista = new ArrayList<Pergunta>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM perguntas";
		
		try {
			pstm = this.conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			while(rst.next()) {
				Pergunta pergunta = new Pergunta();
				pergunta = new Pergunta();
				pergunta.setCod_pergunta(rst.getString("cod_pergunta"));
				pergunta.setTexto(rst.getString("texto_pergunta"));
				lista.add(pergunta);
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
		return lista;
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
