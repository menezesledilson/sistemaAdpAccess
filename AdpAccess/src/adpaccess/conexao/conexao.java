package adpaccess.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Ledi
 */
public class conexao {
    private static final String DRIVER = "net.ucanaccess.jdbc.UcanaccessDriver"; // Nome da classe do driver
    private static String usuario = "";
    private static String senha = "";
    
    private static final String URL = "jdbc:ucanaccess://C:\\sistemaAdp\\AdpAccess\\banco\\banco.mdb"; // Inclua a URL aqui

    public static Connection getConnection() {
        try {
            Class.forName(DRIVER); // Carrega a classe do driver
            return DriverManager.getConnection(URL); // Conecta usando a URL
        } catch (ClassNotFoundException | SQLException erroSql) {
            throw new RuntimeException("ERRO! Não foi possível conectar. " + erroSql);
        }
    }

    public static void closeConnection(Connection con) {
        if (con != null) {
            try {
                con.close();
            } catch (SQLException erroSql) {
                throw new RuntimeException("ERRO! Não foi possível fechar a conexão. " + erroSql);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm) {
        closeConnection(con);
        if (pstm != null) {
            try {
                pstm.close();
            } catch (SQLException erroSql) {
                throw new RuntimeException("ERRO! Não foi possível fechar o PreparedStatement. " + erroSql);
            }
        }
    }

    public static void closeConnection(Connection con, PreparedStatement pstm, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException erroSql) {
                throw new RuntimeException("ERRO! Não foi possível fechar o ResultSet. " + erroSql);
            }
        }
        closeConnection(con, pstm);
    }
}
