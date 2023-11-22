package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Usuarios;

public class UsuariosDAO {
	
	public class LoginResult {
        private boolean isValid;
        private ResultSet resultSet;

        public LoginResult(boolean isValid, ResultSet resultSet) {
            this.isValid = isValid;
            this.resultSet = resultSet;
        }

        public boolean isValid() {
            return isValid;
        }

        public ResultSet getResultSet() {
            return resultSet;
        }
    }
	
	public LoginResult checkLogin(String email, String senha) {
	    Connection conn = null;
	    PreparedStatement stmt = null;
	    ResultSet rs = null;
	    boolean isValid = false;

	    try {
	        conn = ConnectionMySQL.connectConnectionMySQL();
	        String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
	        stmt = conn.prepareStatement(sql);
	        stmt.setString(1, email);
	        stmt.setString(2, senha);
	        rs = stmt.executeQuery();

	        if (rs.next()) {
	            isValid = true;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (rs != null) {
	                rs.close();
	            }
	            if (stmt != null) {
	                stmt.close();
	            }
	            if (conn != null) {
	                ConnectionMySQL.closeConnection(conn);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	    return new LoginResult(isValid, rs);
	}

	//LOGIN
	
	/*public boolean checkLogin(String email, String senha) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        boolean isValid = false;

        try {
            conn = ConnectionMySQL.getConnection();
            String sql = "SELECT * FROM usuarios WHERE email = ? AND senha = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, email);
            stmt.setString(2, senha);
            rs = stmt.executeQuery();

            // Verifica se encontrou um usuário correspondente
            if (rs.next()) {
                isValid = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // Trate a exceção de forma apropriada para o seu aplicativo
        } finally {
            ConnectionMySQL.closeConnection(conn);
        }

        return isValid;
    }*/

    // CREATE
	public void create(Usuarios usuario) throws SQLException {
	    String sql = "INSERT INTO Usuarios (nome, email, senha, cep, endereco, numero, complemento, bairro, estado, cidade) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	    try (Connection conn = ConnectionMySQL.connectConnectionMySQL();
	         PreparedStatement pstm = conn.prepareStatement(sql)) {

	        pstm.setString(1, usuario.getNome());
	        pstm.setString(2, usuario.getEmail());
	        pstm.setString(3, usuario.getSenha());
	        pstm.setString(4, usuario.getCep());
	        pstm.setString(5, usuario.getEndereco());
	        pstm.setString(6, usuario.getNumero());
	        pstm.setString(7, usuario.getComplemento());
	        pstm.setString(8, usuario.getBairro());
	        pstm.setString(9, usuario.getEstado());
	        pstm.setString(10, usuario.getCidade());

	    } catch (ClassNotFoundException e) {
	        e.printStackTrace();
	    }
	}

	//READ
	public List<Usuarios> read() {
		List<Usuarios> usuarios= new ArrayList<Usuarios>();
		String sql = "SELECT * FROM Usuarios";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			
			conn= ConnectionMySQL.connectConnectionMySQL();
			
			pstm= conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
						
			while(rset.next()) {
				Usuarios usuario  = new Usuarios();
				
				usuario.setId(rset.getInt("id_usuario"));
				usuario.setNome(rset.getString("nome"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setCep(rset.getString("cep"));
				usuario.setEndereco(rset.getString("endereco"));
				usuario.setNumero(rset.getString("numero"));
				usuario.setComplemento(rset.getString("complemento"));
				usuario.setBairro(rset.getString("bairro"));
				usuario.setEstado(rset.getString("estado"));
				usuario.setCidade(rset.getString("cidade"));

				
				
				usuarios.add(usuario);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return usuarios;
	}
	
	//UPDATE
	
	public void update(Usuarios usuario) {
		String sql = "UPDATE Usuarios SET nome = ?, email = ?, senha = ?, cep = ?, endereco = ?, numero = ?, complemento = ?, bairro = ?, estado = ?, cidade = ? WHERE id_usuario = ?;";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionMySQL.connectConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());
			pstm.setString(2, usuario.getEmail());
			pstm.setString(3, usuario.getSenha());
			pstm.setString(4, usuario.getCep());
			pstm.setString(5, usuario.getEndereco());
			pstm.setString(6, usuario.getNumero());
			pstm.setString(7, usuario.getComplemento());
			pstm.setString(8, usuario.getBairro());
			pstm.setString(9, usuario.getEstado());
			pstm.setString(10, usuario.getCidade());
			pstm.setInt(11, usuario.getId());
			
			pstm.execute();
	
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		try {
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	  }
	}
	
	//DELETE
	
	public void delete(int Id) {
	String sql = "DELETE FROM Usuarios WHERE id_usuario = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	try {
		conn = ConnectionMySQL.connectConnectionMySQL();
		
		pstm = conn.prepareStatement(sql);
		
		pstm.setInt(1, Id);
		
		pstm.execute();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		  }
	}
	
	//READbyID

	public Usuarios readByID (int Id) {
		Usuarios usuario = new Usuarios ();
		String sql = "select * from Usuarios WHERE id_usuario = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rset = null;
		
		try {
			conn = ConnectionMySQL.connectConnectionMySQL();
			
			pstm = conn.prepareStatement(sql);
			
			pstm.setInt(1, Id);
			
			rset = pstm.executeQuery();
			
			rset.next();
			
			usuario.setId(rset.getInt("id_usuario"));
			usuario.setNome(rset.getString("nome"));
			usuario.setEmail(rset.getString("email"));
			usuario.setSenha(rset.getString("senha"));
			usuario.setCep(rset.getString("cep"));
			usuario.setEndereco(rset.getString("endereco"));
			usuario.setNumero(rset.getString("numero"));
			usuario.setComplemento(rset.getString("complemento"));
			usuario.setBairro(rset.getString("bairro"));
			usuario.setEstado(rset.getString("estado"));
			usuario.setCidade(rset.getString("cidade"));

	    } catch (Exception e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (pstm != null) {
	                pstm.close();
	            }
	            if (conn != null) {
	                conn.close();
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	
	    return usuario;
	}
}