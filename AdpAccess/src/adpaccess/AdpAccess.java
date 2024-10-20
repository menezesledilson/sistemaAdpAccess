/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adpaccess;

import adpaccess.view.adpAccess;
import javax.swing.UIManager;
import javax.swing.WindowConstants;

/**
 *
 * @author Ledi
 */
public class AdpAccess {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      adpAccess formAdpAccess = new adpAccess();
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception e) {
            // Você pode adicionar um log ou tratamento de exceção aqui se necessário
            e.printStackTrace();
        } finally {
            formAdpAccess.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            formAdpAccess.setVisible(true);
        }
    }
    
}
