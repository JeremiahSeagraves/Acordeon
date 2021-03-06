/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import Sesion.User;
import client.ThreadAcordeon;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import models.Log;
import models.Topic;
import server.ManagerTopic;

/**
 *
 * @author Milka
 */
public class ViewModifyTopic extends javax.swing.JFrame {

    
    private ThreadAcordeon thread;
    private User user;
    private ManagerTopic manager;
    
    private ViewModifyTopic(ThreadAcordeon thread, User user) {
        initComponents();
        getLblIdTopic().setVisible(false);
        this.thread = thread;
        this.user = user;
        
    }
    
    private static ViewModifyTopic ventanaModificarTopico = null;
     
    public static ViewModifyTopic obtenerVentanaModificarTopico (ThreadAcordeon thread, User user){
        if(ventanaModificarTopico == null){
            ventanaModificarTopico = new ViewModifyTopic(thread, user);
            return ventanaModificarTopico;
        }
        return ventanaModificarTopico;
    }
    
    public void setManager(ManagerTopic manager){
        this.manager = manager;
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
            Topic topicoModificado = new Topic(id,nombreNuevo);
            manager.finalizemodifyTopic(topicoModificado);
            getTxtNombreTema().setText("");
            this.setVisible(false);
            ViewTopics.obtenerVentanaTopicos(this.thread, this.user).setVisible(true);
            Date date = new Date();
            java.sql.Date datesql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
            Time time = new Time(date.getHours(),date.getMinutes(),date.getSeconds());
            Log log = new Log("modificar", "tema", datesql, time, user.getName());
            try {
                thread.getManagerLogs().createLog(log, user.getIdUser());
            } catch (RemoteException ex) {
                Logger.getLogger(ViewModifyTopic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            JOptionPane.showMessageDialog(this, "No ha escrito un nombre nuevo","Error",JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarTemaActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        try {
            thread.getManagerTopics().createManagerTopic(Integer.parseInt(getLblIdTopic().getText())).cancelLock();
            this.setVisible(false);
            ViewTopics.obtenerVentanaTopicos(this.thread, this.user).setVisible(true);
        } catch (RemoteException ex) {
            Logger.getLogger(ViewModifyTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

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
