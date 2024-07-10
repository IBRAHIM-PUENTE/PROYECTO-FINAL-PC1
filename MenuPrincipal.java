/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package proyectoabyssrúbrica;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.JFrame;

/**
 *
 * @author IBRAHIM29
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        this.setLocationRelativeTo(null);
        AppManager.getInstance().setMainFrame(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnNuevaPartida = new javax.swing.JButton();
        btnVerPuntaje = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI Emoji", 3, 36)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Menú Principal");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 360, 80));

        btnNuevaPartida.setBackground(new java.awt.Color(51, 255, 51));
        btnNuevaPartida.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        btnNuevaPartida.setText("Nueva Partida");
        btnNuevaPartida.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnNuevaPartidaMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnNuevaPartidaMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnNuevaPartidaMousePressed(evt);
            }
        });
        btnNuevaPartida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevaPartidaActionPerformed(evt);
            }
        });
        jPanel2.add(btnNuevaPartida, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 190, 220, 50));

        btnVerPuntaje.setBackground(new java.awt.Color(51, 255, 51));
        btnVerPuntaje.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        btnVerPuntaje.setText("Ver Puntajes");
        btnVerPuntaje.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnVerPuntajeMouseClicked(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnVerPuntajeMouseExited(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnVerPuntajeMousePressed(evt);
            }
        });
        jPanel2.add(btnVerPuntaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 280, 220, 50));

        btnSalir.setBackground(new java.awt.Color(51, 255, 51));
        btnSalir.setFont(new java.awt.Font("Times New Roman", 2, 18)); // NOI18N
        btnSalir.setText("Salir");
        btnSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnSalirMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnSalirMousePressed(evt);
            }
        });
        jPanel2.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 220, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/proyectoabyssrúbrica/flappybirdbg.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 360, 640));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMouseClicked
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(null, "Gracias por jugar :)");
        System.exit(0);
    }//GEN-LAST:event_btnSalirMouseClicked

    private void btnSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSalirMousePressed
        // TODO add your handling code here:
        btnSalir.setBackground(Color.red);
    }//GEN-LAST:event_btnSalirMousePressed

    private void btnVerPuntajeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerPuntajeMousePressed
        // TODO add your handling code here:
        btnVerPuntaje.setBackground(Color.blue);
    }//GEN-LAST:event_btnVerPuntajeMousePressed

    private void btnNuevaPartidaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaPartidaMousePressed
        // TODO add your handling code here:
        btnNuevaPartida.setBackground(Color.orange);
    }//GEN-LAST:event_btnNuevaPartidaMousePressed

    private void btnNuevaPartidaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaPartidaMouseExited
        // TODO add your handling code here:
        btnNuevaPartida.setBackground(Color.green);
    }//GEN-LAST:event_btnNuevaPartidaMouseExited

    private void btnVerPuntajeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerPuntajeMouseExited
        // TODO add your handling code here:
        btnVerPuntaje.setBackground(Color.green);
    }//GEN-LAST:event_btnVerPuntajeMouseExited

    private void btnNuevaPartidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevaPartidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevaPartidaActionPerformed

    private void btnNuevaPartidaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnNuevaPartidaMouseClicked
        // TODO add your handling code here:
        btnNuevaPartida.setBackground(Color.orange);
        // Cierra el menú principal
        AppManager.getInstance().getMainFrame().dispose();
        // Abre el juego
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new App().main(null);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });

    }//GEN-LAST:event_btnNuevaPartidaMouseClicked

    private void btnVerPuntajeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnVerPuntajeMouseClicked
        // TODO add your handling code here:
        btnVerPuntaje.setBackground(Color.blue);
        // Cierra el menú principal
        AppManager.getInstance().getMainFrame().dispose();
        // Abre la ventana de puntajes
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Puntajes().setVisible(true);
            }
        });

    }//GEN-LAST:event_btnVerPuntajeMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnNuevaPartida;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnVerPuntaje;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}