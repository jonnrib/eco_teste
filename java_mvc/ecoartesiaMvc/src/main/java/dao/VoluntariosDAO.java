package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import model.Voluntarios;

public class VoluntariosDAO {

    // CREATE
    public void create (Voluntarios voluntario) {
        String sql = "INSERT INTO Voluntarios (nome, email, disponibilidade, interesses) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, voluntario.getNome());
            pstm.setString(2, voluntario.getEmail());
            pstm.setString(3, voluntario.getDisponibilidade());
            pstm.setString(4, voluntario.getInteresses());

            pstm.executeUpdate();

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

    // READ
	public List<Voluntarios> read() {
        List<Voluntarios> voluntarios = new ArrayList<Voluntarios>();
        String sql = "SELECT * FROM Voluntarios";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Voluntarios voluntario = new Voluntarios();

                voluntario.setId(rset.getInt("id_voluntario"));
                voluntario.setNome(rset.getString("nome"));
                voluntario.setEmail(rset.getString("email"));
                voluntario.setDisponibilidade(rset.getString("disponibilidade"));
                voluntario.setInteresses(rset.getString("interesses"));

                voluntarios.add(voluntario);
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
        return voluntarios;
    }

    // UPDATE
    public void update (Voluntarios voluntario) {
        String sql = "UPDATE Voluntarios SET nome = ?, email = ?, disponibilidade = ?, interesses = ? WHERE id_voluntario = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, voluntario.getNome());
            pstm.setString(2, voluntario.getEmail());
            pstm.setString(3, voluntario.getDisponibilidade());
            pstm.setString(4, voluntario.getInteresses());
            pstm.setInt(5, voluntario.getId());

            pstm.executeUpdate();

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

    // DELETE
    public void delete (int id) {
        String sql = "DELETE FROM Voluntarios WHERE id_voluntario = ?";

        Connection conn = null;
        PreparedStatement pstm = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.executeUpdate();

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
    public Voluntarios readByID (int id) {
        Voluntarios voluntario = new Voluntarios();
        String sql = "SELECT * FROM Voluntarios WHERE id_voluntario = ?";

        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.createConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            rset = pstm.executeQuery();

			rset.next();

            if (rset.next()) {
                voluntario.setId(rset.getInt("id_voluntario"));
                voluntario.setNome(rset.getString("nome"));
                voluntario.setEmail(rset.getString("email"));
                voluntario.setDisponibilidade(rset.getString("disponibilidade"));
                voluntario.setInteresses(rset.getString("interesses"));
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

        return voluntario;
    }
}