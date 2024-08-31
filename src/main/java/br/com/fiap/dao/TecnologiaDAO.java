package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Tecnologia;

public class TecnologiaDAO {
	
	private Connection conexao;
	
	public TecnologiaDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<Tecnologia> listarTecnologias(){
		List<Tecnologia> tecnologias = new ArrayList<Tecnologia>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM tecnologia";
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()) {
				Tecnologia tec = new Tecnologia();
				tec.setCod_tecnologia(rst.getString("cod_tecnologia"));
				tec.setNome(rst.getString("nome_tec"));
				java.util.Date data = rst.getDate("data_implantacao");
				java.sql.Date sqlDate = new java.sql.Date(data.getTime());
				tec.setData_implementacao(sqlDate);
				
				tecnologias.add(tec);
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
		return tecnologias;
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
