package adpaccess.view;

import adpaccess.conexao.conexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class localizarMembro extends javax.swing.JInternalFrame {

    public localizarMembro() {
        initComponents();
        configurarListener();

    }
    private void configurarListener() {
    txtLocalizarNome.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buscarMembro();
        }
    });
}

    private void buscarMembro() {
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rs = null;

        try {
            String nomeText = txtLocalizarNome.getText().trim();
            if (nomeText.isEmpty()) {
                limparLabels();
                return;
            }

            con = conexao.getConnection();
            pstm = con.prepareStatement("SELECT * FROM membro WHERE nome LIKE ?");
            pstm.setString(1, "%" + nomeText + "%");
            rs = pstm.executeQuery();

            if (rs.next()) {
                // Preencher os JLabels com os dados do membro
                lbCodigo.setText(rs.getString("codigo"));
                lbNome.setText(rs.getString("Nome"));
                lbMae.setText(rs.getString("mae"));                
                lbPai.setText(rs.getString("Pai"));
                lbData.setText(rs.getString("datanascimento"));
                lbEstadoCivil.setText(rs.getString("estadocivil"));
                lbNacional.setText(rs.getString("Nacionalidade"));
                lbNatural.setText(rs.getString("Natural"));
                lbCargo.setText(rs.getString("profissao"));
                lbMembro.setText(rs.getString("membrodesde"));
                lbIgreja.setText(rs.getString("referencia"));
                lblProcedencia.setText(rs.getString("procedencia"));
                lbObs.setText(rs.getString("obs"));
               
                lbBatismo.setText(rs.getString("batismoagua"));
            } else {
                JOptionPane.showMessageDialog(null, "Nome não encontrado", "Aviso", JOptionPane.WARNING_MESSAGE);
                limparLabels();
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao acessar o banco de dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        } finally {
            // Fechar recursos
            try {
                if (rs != null) rs.close();
                if (pstm != null) pstm.close();
                if (con != null) con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private void limparLabels() {
        lbCargo.setText("");
        lbData.setText("");
        lbNacional.setText("");
        lbMembro.setText("");
        lbNome.setText("");
        lbPai.setText("");
        lbNatural.setText("");
        lbEstadoCivil.setText("");
        lbMae.setText("");
        lbBatismo.setText("");
       
        lblProcedencia.setText("");
        lbIgreja.setText("");
        lbObs.setText("");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtLocalizarNome = new javax.swing.JTextField();
        lbCodigo = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbMae = new javax.swing.JLabel();
        lbPai = new javax.swing.JLabel();
        lbData = new javax.swing.JLabel();
        lbEstadoCivil = new javax.swing.JLabel();
        lbNacional = new javax.swing.JLabel();
        lbNatural = new javax.swing.JLabel();
        lbCargo = new javax.swing.JLabel();
        lbMembro = new javax.swing.JLabel();
        lbIgreja = new javax.swing.JLabel();
        lblProcedencia = new javax.swing.JLabel();
        lbObs = new javax.swing.JLabel();
        lbBatismo = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setClosable(true);
        setTitle("Localizar");

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(txtLocalizarNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 43, 290, -1));

        lbCodigo.setText("lbCodigo");
        jPanel1.add(lbCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 98, -1, -1));

        jLabel2.setText("Digite o nome");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 23, -1, -1));

        lbNome.setText("lbNome");
        jPanel1.add(lbNome, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 135, -1, -1));

        lbMae.setText("lbMae");
        jPanel1.add(lbMae, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 171, -1, -1));

        lbPai.setText("lbPai");
        jPanel1.add(lbPai, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 203, -1, -1));

        lbData.setText("lbData");
        jPanel1.add(lbData, new org.netbeans.lib.awtextra.AbsoluteConstraints(98, 244, -1, -1));

        lbEstadoCivil.setText("lbEstadoCivil");
        jPanel1.add(lbEstadoCivil, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 276, -1, -1));

        lbNacional.setText("lbNacional");
        jPanel1.add(lbNacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 308, -1, -1));

        lbNatural.setText("lbNatural");
        jPanel1.add(lbNatural, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 340, -1, -1));

        lbCargo.setText("lbCargo");
        jPanel1.add(lbCargo, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 98, -1, -1));

        lbMembro.setText("lbMembro");
        jPanel1.add(lbMembro, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 135, -1, -1));

        lbIgreja.setText("lbIgreja");
        jPanel1.add(lbIgreja, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 171, -1, -1));

        lblProcedencia.setText("lblProcedencia");
        jPanel1.add(lblProcedencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 223, -1, -1));

        lbObs.setText("lbObs");
        jPanel1.add(lbObs, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 265, -1, -1));

        lbBatismo.setText("lbBatismo");
        jPanel1.add(lbBatismo, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 308, -1, -1));

        jLabel1.setText("Codigo");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 98, -1, -1));

        jLabel3.setText("Nome");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(39, 135, -1, -1));

        jLabel4.setText("Mãe");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 171, -1, -1));

        jLabel5.setText("Pai");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 203, -1, -1));

        jLabel6.setText("Est. Civil");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 276, -1, -1));

        jLabel7.setText("Data Bast");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 244, -1, -1));

        jLabel8.setText("Nacionalidade");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 308, -1, -1));

        jLabel9.setText("Natural");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 340, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbBatismo;
    private javax.swing.JLabel lbCargo;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbEstadoCivil;
    private javax.swing.JLabel lbIgreja;
    private javax.swing.JLabel lbMae;
    private javax.swing.JLabel lbMembro;
    private javax.swing.JLabel lbNacional;
    private javax.swing.JLabel lbNatural;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbObs;
    private javax.swing.JLabel lbPai;
    private javax.swing.JLabel lblProcedencia;
    private javax.swing.JTextField txtLocalizarNome;
    // End of variables declaration//GEN-END:variables
}
