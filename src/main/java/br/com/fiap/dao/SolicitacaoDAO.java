package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Solicitacao;

public class SolicitacaoDAO {
	
	private Connection conexao;
	
	public SolicitacaoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public String criarConexao(Solicitacao solicitacao) {
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "INSERT INTO solicitacao (cod_paciente, cod_medico, status, data_solicitacao) VALUES (?,?,?,?)";
		
		String idGerado = null;
		try {
			pstm = conexao.prepareStatement(sql, new String[]{"cod_solicitacao"});
			pstm.setString(1, solicitacao.getCod_paciente());
			pstm.setString(2, solicitacao.getCod_medico());
			pstm.setString(3, solicitacao.getStatus());
			java.util.Date dataAgendada = solicitacao.getData_solicitacao();
			java.sql.Date sqlDate = new java.sql.Date(dataAgendada.getTime());
			pstm.setDate(4, sqlDate);
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
	
	public String retornarStatus(String cod) {
		String status = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT status FROM solicitacao WHERE cod_solicitacao = ?";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod);
			rst = pstm.executeQuery();
			while(rst.next()) {
				status = rst.getString("status");
			}
		}catch (SQLException e) {
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
		return status;
	}
	
	public Solicitacao retornarSolicitacao(String cod) {
		Solicitacao solicitacao = null;
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT cod_paciente, cod_medico FROM solicitacao WHERE cod_solicitacao = ?";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod);
			rst = pstm.executeQuery();
			while(rst.next()) {
				solicitacao = new Solicitacao();
				solicitacao.setCod_paciente(rst.getString("cod_paciente"));
				solicitacao.setCod_medico(rst.getString("cod_medico"));
			}
		}catch (SQLException e) {
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
		return solicitacao;
	}
	
	public List<Solicitacao> listaSolicitacao() {
		List<Solicitacao> lista = new ArrayList<Solicitacao>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT * FROM solicitacao";
		try {
			pstm = conexao.prepareStatement(sql);
			rst = pstm.executeQuery();
			while(rst.next()) {
				Solicitacao soli = new Solicitacao();
				soli.setCod_solicitacao(rst.getString("cod_solicitacao"));
				soli.setCod_paciente(rst.getString("cod_paciente"));
				soli.setCod_medico(rst.getString("cod_medico"));
				soli.setStatus(rst.getString("status"));
				soli.setData_solicitacao(rst.getDate("data_solicitacao"));
				lista.add(soli);
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
	
	public List<Solicitacao> listaSolicitacaoMedico(String cod_medico) {
		List<Solicitacao> lista = new ArrayList<Solicitacao>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT S.COD_SOLICITACAO, S.COD_PACIENTE, P.NOME_PAC, S.COD_MEDICO, S.STATUS, S.DATA_SOLICITACAO "
				+ "FROM solicitacao S "
				+ "JOIN paciente P ON S.COD_PACIENTE = P.COD_PACIENTE "
				+ "WHERE cod_medico = ?";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod_medico);
			rst = pstm.executeQuery();
			while(rst.next()) {
				Solicitacao soli = new Solicitacao();
				soli.setCod_solicitacao(rst.getString("cod_solicitacao"));
				soli.setCod_paciente(rst.getString("cod_paciente"));
				soli.setNome(rst.getString("nome_pac"));
				soli.setCod_medico(rst.getString("cod_medico"));
				soli.setStatus(rst.getString("status"));
				soli.setData_solicitacao(rst.getDate("data_solicitacao"));
				lista.add(soli);
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
	
	public List<Solicitacao> listaSolicitacaoPaciente(String cod_paciente) {
		List<Solicitacao> lista = new ArrayList<Solicitacao>();
		PreparedStatement pstm = null;
		ResultSet rst = null;
		String sql = "SELECT S.COD_SOLICITACAO, S.COD_PACIENTE, M.NOME_MED, S.COD_MEDICO, S.STATUS, S.DATA_SOLICITACAO "
				+ "FROM solicitacao S "
				+ "JOIN medico M ON S.COD_MEDICO = M.COD_MEDICO "
				+ "WHERE cod_paciente = ?";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, cod_paciente);
			rst = pstm.executeQuery();
			while(rst.next()) {
				Solicitacao soli = new Solicitacao();
				soli.setCod_solicitacao(rst.getString("cod_solicitacao"));
				soli.setCod_paciente(rst.getString("cod_paciente"));
				soli.setNomeM(rst.getString("nome_med"));
				soli.setCod_medico(rst.getString("cod_medico"));
				soli.setStatus(rst.getString("status"));
				soli.setData_solicitacao(rst.getDate("data_solicitacao"));
				lista.add(soli);
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
	
	public void atualizaStatus(String cod_solicitacao, String status) {
		PreparedStatement pstm = null;
		String sql = "UPDATE solicitacao S SET S.status = ? WHERE cod_solicitacao = ?";
		try {
			pstm = this.conexao.prepareStatement(sql);
			pstm.setString(1, status);
			pstm.setString(2, cod_solicitacao);
			pstm.execute();
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

