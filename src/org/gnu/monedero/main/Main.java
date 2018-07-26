/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gnu.monedero.main;

import org.gnu.monedero.certificado.Reportes;
import org.gnu.monedero.dao.DaoMysqlSsh;
import org.gnu.monedero.gui.Detalles;
import org.gnu.monedero.gui.Fondo;
import org.gnu.monedero.gui.Verificacion;
import org.gnu.monedero.utils.Config;


/**
 *
 * @author user
 */
public class Main {


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Config.initializeLog4j2();
        Config.ssh();
         try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Verificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Verificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Verificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Verificacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Fondo().setVisible(false);
                new Verificacion().setVisible(true);
               //new Detalles().setVisible(true);
                //DaoMysql daoMysql =  new DaoMysql();
                //daoMysql.get();
                //Reportes r =  new Reportes();
                //r.imprimir("0930051495","inscripcion");
                
                //System.out.println();
                        
            }
        });
    }
}

