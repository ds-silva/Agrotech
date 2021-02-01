package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionFactory {

    /*
    *   Nome do Host: 
    *   resilia.super10.com.br:5432
    *   database : agrotech
    *   Username: bdresilia
    *   password: HQ2e3vD!opWX
     */
    
    /*
    *   Nome do Host: 
    *   resilia.super10.com.br:5432
    *   database : teste
    *   Username: devs
    *   password: devs2020
     */
    
    private static final String DRIVER = "org.postgresql.Driver";
    private static final String URL = "jdbc:postgresql://resilia.super10.com.br:5432/agrotech";
    private static final String USER = "bdresilia";
    private static final String PASS = "HQ2e3vD!opWX";

    public static Connection getConnection() {

        try {

            Class.forName(DRIVER);
            return DriverManager.getConnection(URL, USER, PASS);

        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException("Erro ao abrir conexão com banco de dados! " + ex);
        }

    }

    public static void closeConnection(Connection con)  {

        if (con != null) {
            try {
                con.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão com banco de dados! " + ex);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement stmt)  {

        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
               throw new RuntimeException("Erro ao fechar conexão com banco de dados! - PreparedStatement" + ex);
            }
        }

        closeConnection(con);

    }

    public static void closeConnection(Connection con, PreparedStatement stmt, ResultSet rs)  {

        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar conexão com banco de dados! - ResultSet" + ex);
            }
        }
        
         if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
               throw new RuntimeException("Erro ao fechar conexão com banco de dados! - PreparedStatement" + ex);
            }
        }

        closeConnection(con);

    }

}
