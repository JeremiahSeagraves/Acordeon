/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import database.DAOTopic;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Topic;

/**
 *
 * @author Milka
 */
public class ViewModifyTopic extends javax.swing.JFrame {

    /**
     * Creates new form ViewCreateTopics
     */
    private ViewModifyTopic() {
        initComponents();
        getLblIdTopic().setVisible(false);
        
    }
    
    private static ViewModifyTopic ventanaModificarTopico = null;
     
    public static ViewModifyTopic obtenerVentanaModificarTopico (){
        if(ventanaModificarTopico == null){
            ventanaModificarTopico = new ViewModifyTopic();
            return ventanaModificarTopico;
        }
        return ventanaModificarTopico;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtNombreTema = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnModificarTema = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lblModificarTema = new javax.swing.JLabel();
        lblIdTopic = new javax.swing.JLabel();
        lblUsuarioLogeado = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar tema");

        jLabel1.setText("Nombre");

        btnModificarTema.setText("Modificar");
        btnModificarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTemaActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblModificarTema.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblModificarTema.setText("Modificar...");

        lblUsuarioLogeado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(btnModificarTema)
                        .addGap(61, 61, 61)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(19, 19, 19)
                            .addComponent(lblModificarTema)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblIdTopic))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addGap(46, 46, 46)
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtNombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblModificarTema)
                    .addComponent(lblIdTopic))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombreTema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificarTema)
                    .addComponent(btnCancelar))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTemaActionPerformed
        String nombreNuevo = getTxtNombreTema().getText();
        int id = Integer.parseInt(getLblIdTopic().getText());
        if(!nombreNuevo.equals("")){
            try {
                Topic topicoModificado = new Topic(id,nombreNuevo);
                DAOTopic accesoTemas = new DAOTopic();
                accesoTemas.actualizarTopico(topicoModificado);
            } catch (SQLException ex) {
                Logger.getLogger(ViewModifyTopic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewModifyTopic.class.getName()).log(Level.SEVERE, null, ex);
            }
            getTxtNombreTema().setText("");
            this.setVisible(false);
            ViewTopics.obtenerVentanaTopicos().setVisible(true);
        }
        else{
            JOptionPane.showMessageDialog(this, "No ha escrito un nombre nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarTemaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       this.setVisible(false);
       ViewTopics.obtenerVentanaTopicos().setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewModifyTopic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewModifyTopic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewModifyTopic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewModifyTopic.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewModifyTopic().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificarTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblIdTopic;
    private javax.swing.JLabel lblModificarTema;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JTextField txtNombreTema;
    // End of variables declaration//GEN-END:variables

    public static ViewModifyTopic getVentanaModificarTopico() {
        return ventanaModificarTopico;
    }

    public static void setVentanaModificarTopico(ViewModifyTopic ventanaModificarTopico) {
        ViewModifyTopic.ventanaModificarTopico = ventanaModificarTopico;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnModificarTema() {
        return btnModificarTema;
    }

    public void setBtnModificarTema(JButton btnModificarTema) {
        this.btnModificarTema = btnModificarTema;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getLblModificarTema() {
        return lblModificarTema;
    }

    public void setLblModificarTema(JLabel lblModificarTema) {
        this.lblModificarTema = lblModificarTema;
    }

    public JTextField getTxtNombreTema() {
        return txtNombreTema;
    }

    public void setTxtNombreTema(JTextField txtNombreTema) {
        this.txtNombreTema = txtNombreTema;
    }

    public JLabel getLblIdTopic() {
        return lblIdTopic;
    }

    public void setLblIdTopic(JLabel lblIdTopic) {
        this.lblIdTopic = lblIdTopic;
    }

    public JLabel getLblUsuarioLogeado() {
        return lblUsuarioLogeado;
    }

    public void setLblUsuarioLogeado(JLabel lblUsuarioLogeado) {
        this.lblUsuarioLogeado = lblUsuarioLogeado;
    }
}