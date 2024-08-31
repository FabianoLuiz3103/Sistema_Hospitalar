package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.fiap.bean.Paciente;

public class PacienteDAO {
	
	private Connection conexao;
	
	public PacienteDAO(Connection conexao) {
		this.conexao = conexao;
	}
	
	public void cadastrarPaciente(Paciente paciente) {
		PreparedStatement pstm = null;
		String sql = "INSERT INTO paciente (nome_pac, email_pac, telefone_pac, senha, cpf, idade, sexo) VALUES (?,?,?,?,?,?,?)";
		try {
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, paciente.getNome());
			pstm.setString(2, paciente.getEmail());
			pstm.setString(3, paciente.getTelefone());
			pstm.setString(4, paciente.getSenha());
			pstm.setString(5, paciente.getCpf());
			pstm.setInt(6, paciente.getIdade());
			pstm.setString(7, paciente.getSexo());
			
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
	
   public List<Paciente> listarPacientes(){
	   List<Paciente> pacientes = new ArrayList<Paciente>();
	   PreparedStatement pstm = null;
	   ResultSet rst = null;
	   String sql = "SELECT * FROM paciente ORDER BY idade DESC";
	   
	   try {
		pstm = conexao.prepareStatement(sql);
		rst = pstm.executeQuery();
		
		while(rst.next()) {
			Paciente pac = new Paciente();
			pac.setCod_paciente(rst.getString("cod_paciente"));
			pac.setNome(rst.getString("nome_pac"));
			pac.setEmail(rst.getString("email_pac"));
			pac.setTelefone(rst.getString("telefone_pac"));
			pac.setSenha(rst.getString("senha"));
			pac.setCpf(rst.getString("cpf"));
			pac.setIdade(rst.getInt("idade"));
			pac.setSexo(rst.getString("sexo"));
			
			pacientes.add(pac);
			
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
	 return pacientes;  
	   
   }
   
   public Paciente dadosPaciente(String cpf_cod) {
	    Paciente paciente = new Paciente();
	    PreparedStatement pstm = null;
	    ResultSet rst = null;
	    String sql = "SELECT * FROM paciente WHERE cpf = ? OR cod_paciente = ?";
	    
	    try {
	        pstm = conexao.prepareStatement(sql);
	        pstm.setString(1, cpf_cod);
	        pstm.setString(2, cpf_cod);
	        rst = pstm.executeQuery();
	        
	        while(rst.next()) {
	        	
	        	paciente.setCod_paciente(rst.getString("cod_paciente"));
	        	paciente.setNome(rst.getString("nome_pac"));
	        	paciente.setEmail(rst.getString("email_pac"));
	        	paciente.setTelefone(rst.getString("telefone_pac"));
	        	paciente.setSenha(rst.getString("senha"));
	        	paciente.setCpf(rst.getString("cpf"));
	        	paciente.setIdade(rst.getInt("idade"));
	        	paciente.setSexo(rst.getString("sexo"));
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
	    return paciente;
	}

   
   public void atualizarCadastro(Paciente paciente, String codigo) {
	   PreparedStatement pstm = null;
	   String sql = "UPDATE paciente P SET P.nome_pac = ?, P.email_pac = ?, P.telefone_pac = ?, P.senha = ?, P.idade = ? WHERE cod_paciente = ?";
	   
	   try {
		pstm = conexao.prepareStatement(sql);
		pstm.setString(1, paciente.getNome());
		pstm.setString(2, paciente.getEmail());
		pstm.setString(3, paciente.getTelefone());
		pstm.setString(4, paciente.getSenha());
		pstm.setInt(5, paciente.getIdade());
		pstm.setString(6, codigo);
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
   
   public boolean buscar(String coluna, String valor) {
	    String sql = "SELECT " + coluna + " FROM paciente WHERE " + coluna + " = ?";
	    
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
   
   public boolean buscarUpdate(String coluna, String valor, String cod_paciente) {
	    String sql = "SELECT * FROM paciente WHERE cod_paciente = ?";
	    boolean b = false;

	    try (PreparedStatement pstm = conexao.prepareStatement(sql)) {
	        pstm.setString(1, cod_paciente);

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

   
   public boolean validarPaciente(String cpf, String senha) {
		PreparedStatement pstm = null;
		ResultSet rst = null;
		try {
			pstm = conexao.prepareStatement("SELECT * FROM paciente WHERE cpf = ? AND senha = ?");
			pstm.setString(1, cpf);
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
   
   public void alterarSenha(String senha, String cpf) {
		PreparedStatement pstm = null;
		String sql = "UPDATE paciente P SET P.senha = ? WHERE P.cpf = ? ";
		try {
			pstm = conexao.prepareStatement(sql);

			pstm.setString(1, senha);
			pstm.setString(2, cpf);
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
