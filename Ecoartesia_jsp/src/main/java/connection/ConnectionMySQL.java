package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySQL {
    private static String URL = System.getenv("JTV_URL");
    private static String USUARIO = System.getenv("JTV_USUARIO");
    private static String SENHA = System.getenv("JTV_SENHA");

    public static Connection connectConnectionMySQL() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);
        return connection;
    }

    public static void closeConnection(Connection connection) {
        try {
            if (connection != null && !connection.isClosed()) {
                connection.close();
                // Use a logging framework instead of printing
                System.out.println("Connection closed successfully!");
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log this exception using a logging framework
        }
    }

    public static void main(String[] args) {
        try {
            Connection con = connectConnectionMySQL();
            if (con != null) {
                System.out.println(con + "\n\n ***  CONNECTION OBTAINED SUCCESSFULLY! ******");
                closeConnection(con); // Closing the connection here, for example
            }
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(); // Log this exception using a logging framework
        }
    }
}