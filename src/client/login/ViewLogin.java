/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.login;

import Sesion.Cuenta;
import Sesion.User;
import client.ThreadAcordeon;
import database.DAOUser;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import client.topics.ViewTopics;

/**
 *
 * @author juan
 */
public class ViewLogin extends javax.swing.JFrame {

    ThreadAcordeon thread;
    
    private ViewLogin(ThreadAcordeon thread) {
        initComponents();
        this.thread = thread;
    }

    private static ViewLogin ventanaLogin = null;

    public static ViewLogin obtenerVentanaLogin(ThreadAcordeon thread) {
        if (ventanaLogin == null) {
            ventanaLogin = new ViewLogin(thread);
            ventanaLogin.setVisible(true);
            return ventanaLogin;
        }
        ventanaLogin.setVisible(true);
        return ventanaLogin;
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pswContrasenia = new javax.swing.JPasswordField();
        btnIniciar = new javax.swing.JButton();
        btnRegistrar7 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Inicio de sesión");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnRegistrar7.setText("Registrar");
        btnRegistrar7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrar7ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addComponent(btnIniciar)
                        .addGap(87, 87, 87)
                        .addComponent(btnRegistrar7))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pswContrasenia)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pswContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnIniciar)
                    .addComponent(btnRegistrar7))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed

        try {
            String usuario = getTxtUsuario().getText();
            String clave = String.valueOf(getPswContrasenia().getPassword());
            DAOUser accesoUsuarios = new DAOUser();
            User unUsuario = accesoUsuarios.validarUsuario(usuario, clave);
            if (unUsuario == null) {
                JOptionPane.showMessageDialog(this, "Error al iniciar sesión", "Error de inicio de sesión",
                        JOptionPane.ERROR_MESSAGE);
            } else {
                Cuenta.obtenerCuentaIniciada();
                Cuenta.establecerCuentaIniciada(unUsuario.getIdUser(), unUsuario.getName());
                this.setVisible(false);
                ViewTopics.obtenerVentanaTopicos(this.thread, unUsuario ).getLblUsuarioLogeado().setText(usuario);
                ViewTopics.obtenerVentanaTopicos(this.thread, unUsuario).setVisible(true);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnRegistrar7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrar7ActionPerformed
        this.setVisible(false);
        ViewRegister.obtenerVentanaRegister(this.thread).setVisible(true);

    }//GEN-LAST:event_btnRegistrar7ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIniciar;
    private javax.swing.JButton btnRegistrar7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pswContrasenia;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static ViewLogin getVentanaLogin() {
        return ventanaLogin;
    }

    public static void setVentanaLogin(ViewLogin ventanaLogin) {
        ViewLogin.ventanaLogin = ventanaLogin;
    }

    public JButton getBtnIniciar() {
        return btnIniciar;
    }

    public void setBtnIniciar(JButton btnIniciar) {
        this.btnIniciar = btnIniciar;
    }

    public JButton getBtnRegistrar7() {
        return btnRegistrar7;
    }

    public void setBtnRegistrar7(JButton btnRegistrar7) {
        this.btnRegistrar7 = btnRegistrar7;
    }

    public JLabel getjLabel1() {
        return jLabel1;
    }

    public void setjLabel1(JLabel jLabel1) {
        this.jLabel1 = jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public void setjLabel3(JLabel jLabel3) {
        this.jLabel3 = jLabel3;
    }

    public JPasswordField getPswContrasenia() {
        return pswContrasenia;
    }

    public void setPswContrasenia(JPasswordField pswContrasenia) {
        this.pswContrasenia = pswContrasenia;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public void setTxtUsuario(JTextField txtUsuario) {
        this.txtUsuario = txtUsuario;
    }

    @Override
    public void setVisible(boolean b) {
        getTxtUsuario().setText("");
        getPswContrasenia().setText("");
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }
}
