package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import connection.ConnectionMySQL;
import modelos.Campanhas;

public class CampanhasDAO {

    Connection conn = null;
    PreparedStatement pstm = null;

    public void save(Campanhas campanha) {

        String sql = "INSERT INTO campanhas(nome, descricao, meta_arrecadacao, data_inicio, data_termino)" +
                     " VALUES(?, ?, ?, ?, ?)";

        try {
            conn = ConnectionMySQL.connectConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, campanha.getNome());
            pstm.setString(2, campanha.getDescricao());
            pstm.setBigDecimal(3, campanha.getMetaArrecadacao());
            pstm.setDate(4, Date.valueOf(campanha.getDataInicio()));
            pstm.setDate(5, Date.valueOf(campanha.getDataTermino()));

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM campanhas WHERE id_campanha = ?";

        try {
            conn = ConnectionMySQL.connectConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setInt(1, id);

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    public void update(Campanhas campanha) {

        String sql = "UPDATE campanhas SET nome = ?, descricao = ?, meta_arrecadacao = ?, " +
                     "data_inicio = ?, data_termino = ? WHERE id_campanha = ?";

        try {
            conn = ConnectionMySQL.connectConnectionMySQL();
            pstm = conn.prepareStatement(sql);

            pstm.setString(1, campanha.getNome());
            pstm.setString(2, campanha.getDescricao());
            pstm.setBigDecimal(3, campanha.getMetaArrecadacao());
            pstm.setDate(4, Date.valueOf(campanha.getDataInicio()));
            pstm.setDate(5, Date.valueOf(campanha.getDataTermino()));
            pstm.setInt(6, campanha.getIdCampanha());

            pstm.execute();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }
    }

    public List<Campanhas> getCampanhas() throws Exception {
        String sql = "SELECT * FROM campanhas";
        List<Campanhas> campanhas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.connectConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Campanhas campanha = new Campanhas();
                campanha.setIdCampanha(rset.getInt("id_campanha"));
                campanha.setNome(rset.getString("nome"));
                campanha.setDescricao(rset.getString("descricao"));
                campanha.setMetaArrecadacao(rset.getBigDecimal("meta_arrecadacao"));
                campanha.setDataInicio(rset.getDate("data_inicio").toLocalDate());
                campanha.setDataTermino(rset.getDate("data_termino").toLocalDate());
                campanhas.add(campanha);
            }

        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception appropriately, log it, or throw a custom exception
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace(); // Handle the exception appropriately, log it, or throw a custom exception
            }
        }

        return campanhas;
    }

    public Campanhas getCampanhaById(int id) {

        String sql = "SELECT * FROM campanhas WHERE id_campanha = ?";
        Campanhas campanha = new Campanhas();

        ResultSet rset = null;

        try {
            conn = ConnectionMySQL.connectConnectionMySQL();
            pstm = conn.prepareStatement(sql);
            pstm.setInt(1, id);
            rset = pstm.executeQuery();

            if (rset.next()) {
                campanha.setIdCampanha(rset.getInt("id_campanha"));
                campanha.setNome(rset.getString("nome"));
                campanha.setDescricao(rset.getString("descricao"));
                campanha.setMetaArrecadacao(rset.getBigDecimal("meta_arrecadacao"));
                campanha.setDataInicio(rset.getDate("data_inicio").toLocalDate());
                campanha.setDataTermino(rset.getDate("data_termino").toLocalDate());
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeConnections();
        }

        return campanha;
    }

    private void closeConnections() {
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