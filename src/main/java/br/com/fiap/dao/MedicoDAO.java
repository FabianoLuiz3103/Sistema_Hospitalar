package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Medico;

public class MedicoDAO {
	
private Connection conexao;
	
	public MedicoDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrarMedico(Medico medico) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO medico (nome_med, email_med, telefone_med, crm, cod_especialidade, senha) VALUES (?,?,?,?,?,?)";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, medico.getNome());
			pstm.setString(2, medico.getEmail());
			pstm.setString(3, medico.getTelefone());
			pstm.setString(4, medico.getCrm());
			pstm.setString(5, medico.getCod_especialidade());
			pstm.setString(6, medico.getSenha());
			
			pstm.executeUpdate();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {			try {
				if (pstm != null) {
					pstm.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	
   public List<Medico> listarPorEspecialidade(String cod_especialidade){
	   List<Medico> medicos = new ArrayList<Medico>();
	   PreparedStatement pstm = null;
	   ResultSet rst = null;
	   String sql = "SELECT * FROM medico WHERE cod_especialidade = ?";
	   
	   try {
		pstm = conexao.prepareStatement(sql);
		pstm.setString(1, cod_especialidade);
		rst = pstm.executeQuery();
		
		while(rst.next()) {
			Medico med = new Medico();
			med.setCod_medico(rst.getString("cod_medico"));
			med.setNome(rst.getString("nome_med"));
			med.setEmail(rst.getString("email_med"));
			med.setTelefone(rst.getString("telefone_med"));
			med.setCrm(rst.getString("crm"));
			med.setCod_especialidade(rst.getString("cod_especialidade"));
			
			medicos.add(med);
			
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
	 return medicos;  
	   
   }
   
   public Medico dadosMedico(String crm_cod) {
	   Medico medico = new Medico();
	   PreparedStatement pstm = null;
	   ResultSet rst = null;
	   String sql = "SELECT * FROM medico WHERE crm = ? OR cod_medico = ?";
	   
	   try {
		pstm = conexao.prepareStatement(sql);
		pstm.setString(1, crm_cod);
		pstm.setString(2, crm_cod);
		rst = pstm.executeQuery();
		
		while(rst.next()) {
			medico.setCod_medico(rst.getString("cod_medico"));
			medico.setNome(rst.getString("nome_med"));
			medico.setEmail(rst.getString("email_med"));
			medico.setTelefone(rst.getString("telefone_med"));
			medico.setCrm(rst.getString("crm"));
			medico.setCod_especialidade(rst.getString("cod_especialidade"));
			medico.setSenha(rst.getString("senha"));
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
	   return medico;
   }
   
   public void atualizarCadastro(Medico medico, String cod_medico) {
	   PreparedStatement pstm = null;
	   String sql = "UPDATE medico M SET M.nome_med = ?, M.email_med = ?, M.telefone_med = ?, M.senha = ? WHERE cod_medico = ?";
	   
	   try {
		pstm = conexao.prepareStatement(sql);
		pstm.setString(1, medico.getNome());
		pstm.setString(2, medico.getEmail());
		pstm.setString(3, medico.getTelefone());
		pstm.setString(4, medico.getSenha());
		pstm.setString(5, cod_medico);
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
   
   public boolean validarMedico(String crm, String senha) {
		PreparedStatement pstm = null;
		ResultSet rst = null;
		try {
			pstm = conexao.prepareStatement("SELECT * FROM medico WHERE crm = ? AND senha = ?");
			pstm.setString(1, crm);
			pstm.setString(2, senha);
			rst = pstm.executeQuery();

			if (rst.next()) {
				return true;
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
		return false;
	}
   
   public boolean buscar(String coluna, String valor) {
	    String sql = "SELECT " + coluna + " FROM medico WHERE " + coluna + " = ?";
	    
	    try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
	        pstm.setString(1, valor);

	        try (ResultSet rst = pstm.executeQuery()) {
	            return rst.next(); 
	        }
	    } catch (SQLException e) {
	        e.printStackTrace(); 
	    }

	    return false;
  }
  
  public boolean buscarUpdate(String coluna, String valor, String cod_medico) {
	    String sql = "SELECT * FROM medico WHERE cod_medico = ?";
	    boolean b = false;

	    try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
	        pstm.setString(1, cod_medico);

	        try (ResultSet rst = pstm.executeQuery()) {
	            if (rst.next()) {
	                String resultado = rst.getString(coluna);
	                System.out.println("Resultado do Banco de Dados: " + resultado);

	                // Simplifique a lógica de comparação
	                b = resultado != null && resultado.equals(valor);

	                System.out.println("Coluna: " + coluna);
	                System.out.println("Valor: " + valor);
	                System.out.println("boool " + b);
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return b;
	}
  
  public void alterarSenha(String senha, String crm) {
		PreparedStatement pstm = null;
		String sql = "UPDATE medico M SET M.senha = ? WHERE M.crm = ? ";
		try {
			pstm = conexao.prepareStatement(sql);

			pstm.setString(1, senha);
			pstm.setString(2, crm);
			pstm.execute();

		} catch (SQLException e) {
			throw new RuntimeException(e);
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
