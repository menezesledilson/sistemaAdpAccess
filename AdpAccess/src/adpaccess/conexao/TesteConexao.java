package adpaccess.conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TesteConexao {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Obtém a conexão
            conn = conexao.getConnection();
            System.out.println("Conexão estabelecida com sucesso!");

            // Cria um Statement para executar uma consulta
            stmt = conn.createStatement();
            String sql = "SELECT * FROM membro"; // Ajuste o nome da tabela conforme necessário
            rs = stmt.executeQuery(sql);

            // Exibe os resultados da consulta
            while (rs.next()) {
                System.out.println("Membro: " + rs.getString("nome")); // Ajuste o nome da coluna conforme necessário
            }
        } catch (SQLException e) {
            System.out.println("Erro ao conectar ou executar a consulta: " + e.getMessage());
        } finally {
            // Fecha a conexão e outros recursos
            conexao.closeConnection(conn, (PreparedStatement) stmt, rs);
        }
    }
}
