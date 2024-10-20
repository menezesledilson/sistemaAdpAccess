package adpaccess.dao;

import adpaccess.conexao.conexao;
import adpaccess.model.Membros;
import java.awt.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ledi
 */
public class membroDao {

    public void adicionar(Membros membros) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("INSERT INTO membro(id,codigo, mae, nome, pai, idade, datanascimento, estadocivil, nacionalidade, natural, profissao, membrodesde, referencia, batismoagua, procedencia, obs, falecido, foto) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?, ?,)");
            pstm.setLong(1, membros.getCodigo());
            pstm.setString(2, membros.getNome());
            pstm.setString(3, membros.getPai());
            pstm.setString(4, membros.getMae());
            pstm.setString(5, membros.getIdade());
            pstm.setString(6, membros.getDatanascimento());
            pstm.setString(7, membros.getEstadocivil());
            pstm.setString(8, membros.getNatural());
            pstm.setString(9, membros.getMembrodesde());
            pstm.setString(10, membros.getReferencia());
            pstm.setString(11, membros.getBatismoagua());
            pstm.setString(12, membros.getProcedencia());
            pstm.setString(13, membros.getObs());
            pstm.setString(14, membros.getFalecido());
            pstm.setString(15, membros.getFoto());

            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Adicionado com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public void remover(Membros membros) {
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;

        try {
            pstm = con.prepareStatement("DELETE FROM membro WHERE id = ?");
            pstm.setLong(1, membros.getId());
            pstm.executeUpdate();
            JOptionPane.showMessageDialog(null, "Removido com sucesso.", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao remover: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm);
        }
    }

    public java.util.List<Membros> listaMembro() {
        java.util.List<Membros> controleMembros = new ArrayList<>();
        Connection con = conexao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            pstm = con.prepareStatement("SELECT * FROM membro");
            rs = pstm.executeQuery();
            while (rs.next()) {
                Membros controleMembro = new Membros();

                controleMembro.setId(rs.getLong("id"));
                controleMembro.setCodigo(rs.getLong("codigo"));
                controleMembro.setMae(rs.getString("mae"));
                controleMembro.setNome(rs.getString("nome"));
                controleMembro.setPai(rs.getString("pai"));
                controleMembro.setIdade(rs.getString("idade"));
                controleMembro.setDatanascimento(rs.getString("datanascimento"));
                controleMembro.setEstadocivil(rs.getString("estadocivil"));
                controleMembro.setNacionalidade(rs.getString("nacionalidade"));
                controleMembro.setNatural(rs.getString("natural"));
                controleMembro.setProfissao(rs.getString("profissao"));
                controleMembro.setMembrodesde(rs.getString("membrodesde"));
                controleMembro.setReferencia(rs.getString("referencia"));
                controleMembro.setNacionalidade(rs.getString("batismoagua"));
                controleMembro.setProcedencia(rs.getString("procedencia"));
                controleMembro.setObs(rs.getString("obs"));
                controleMembro.setFalecido(rs.getString("falecido"));
                controleMembro.setFoto(rs.getString("foto"));
                
                controleMembros.add(controleMembro);
            }
        } catch (SQLException ErroSql) {
            JOptionPane.showMessageDialog(null, "Erro ao listar dados: " + ErroSql, "Erro", JOptionPane.ERROR_MESSAGE);
        } finally {
            conexao.closeConnection(con, pstm, rs);
        }
        return controleMembros;

    }
}
