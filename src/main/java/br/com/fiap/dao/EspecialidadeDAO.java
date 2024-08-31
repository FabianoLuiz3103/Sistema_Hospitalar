package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Especialidade;
import br.com.fiap.bean.Medico;

public class EspecialidadeDAO {
	
	private Connection conexao;
	
	public EspecialidadeDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public List<Especialidade> listarEspecialidades(){
		List<Especialidade> especialidades = new ArrayList<Especialidade>();
		PreparedStatement pstm = null;
		ResultSet rst =  null;
		String sql = "SELECT * FROM especialidade";
		
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			
			while(rst.next()){
				Especialidade esp = new Especialidade();
				esp.setCod_especialidade(rst.getString("cod_especialidade"));
				esp.setNome(rst.getString("nome_espec"));
				
				especialidades.add(esp);
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
		return especialidades;
		
	}
	
	public List<Especialidade> listaComMedico(){
		try {
			Especialidade especialidadeAtual = null;
			List<Especialidade> especialidades = new ArrayList<Especialidade>();
			String sql = "SELECT E.cod_especialidade, E.nome_espec, M.cod_medico, M.nome_med, M.email_med, M.telefone_med, M.crm, M.cod_especialidade "
					+ "FROM especialidade E INNER JOIN medico M ON E.cod_especialidade = M.cod_especialidade";
			
			try(PreparedStatement pstm = conexao.prepareStatement(sql)){
				pstm.execute();
				ResultSet rst = pstm.getResultSet();
				
				while(rst.next()) {
					if(especialidadeAtual == null || !especialidadeAtual.getNome().equals(rst.getString("nome_espec"))) {
						Especialidade especialidade = new Especialidade();
						especialidade.setCod_especialidade(rst.getString("cod_especialidade"));
						especialidade.setNome(rst.getString("nome_espec"));
						especialidades.add(especialidade);
						especialidadeAtual = especialidade;
					}
					Medico medico = new Medico();
				    medico.setCod_medico(rst.getString("cod_medico"));
					medico.setNome(rst.getString("nome_med"));
					medico.setEmail(rst.getString("email_med"));
					medico.setTelefone(rst.getString("telefone_med"));
					medico.setCrm(rst.getString("crm"));
					medico.setCod_especialidade(rst.getString("cod_especialidade"));
					especialidadeAtual.adicionarMedico(medico);
				}
				rst.close();
				pstm.close();
				return especialidades;
			}
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public Especialidade buscarPorCod(String cod){
		Especialidade especialidade = new Especialidade();
		PreparedStatement pstm = null;
		ResultSet rst =  null;
		String sql = "SELECT * FROM especialidade WHERE cod_especialidade = ?";
		
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod);
			rst = pstm.executeQuery();
			
			while(rst.next()){
				especialidade.setCod_especialidade(rst.getString("cod_especialidade"));
				especialidade.setNome(rst.getString("nome_espec"));
				
				
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
		return especialidade;
		
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
