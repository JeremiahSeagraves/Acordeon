/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.login;

import Sesion.User;
import client.ThreadAcordeon;
import database.DAOUser;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author juan
 */
public class ViewRegister extends javax.swing.JFrame {

    private ThreadAcordeon thread;
    
    private ViewRegister(ThreadAcordeon thread) {
        initComponents();
        this.thread = thread;
    }

     private static ViewRegister ventanaRegister = null;
     
    public static ViewRegister obtenerVentanaRegister (ThreadAcordeon thread){
        if(ventanaRegister == null){
            ventanaRegister = new ViewRegister(thread);
            ventanaRegister.setVisible(true);
            return ventanaRegister;
        }
        ventanaRegister.setVisible(true);
        return ventanaRegister;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        pswContrasenia = new javax.swing.JPasswordField();
        btnRegistrar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pswContrasenia2 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Registrar usuario");

        jLabel2.setText("Usuario");

        jLabel3.setText("Contraseña");

        btnRegistrar.setText("Registrar");
        btnRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        jLabel4.setText("Vuelve a escribir la contraseña");

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
                        .addComponent(btnRegistrar)
                        .addGap(87, 87, 87)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)
                            .addComponent(pswContrasenia2)
                            .addComponent(pswContrasenia, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(86, Short.MAX_VALUE))
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
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(pswContrasenia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pswContrasenia2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnRegistrar)
                    .addComponent(btnCancelar))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarActionPerformed
        String usuario = getTxtUsuario().getText();
        String clave1 = String.valueOf(getPswContrasenia().getPassword());
        String clave2 = String.valueOf(getPswContrasenia2().getPassword());
        if(!clave1.equals(clave2)){
            JOptionPane.showMessageDialog(this,"Las contrasenias no coinciden", "Error",JOptionPane.WARNING_MESSAGE);
        }else{
            if(usuario.isEmpty()||clave1.isEmpty()||clave2.isEmpty()){
                    JOptionPane.showMessageDialog(this,"No has llenado todos los campos", "Error",JOptionPane.WARNING_MESSAGE);
            }else{
                DAOUser accesoUsuarios = new DAOUser();
                try {
                    if(accesoUsuarios.validarUsuario(usuario, clave1)!=null){
                        JOptionPane.showMessageDialog(this, "El usuario ya existe.","Error",JOptionPane.WARNING_MESSAGE);
                    }
                    else{
                        User usuarioNuevo = new User(usuario, clave1);
                        accesoUsuarios.insertarUsuario(usuarioNuevo);
                        JOptionPane.showMessageDialog(this, "Registrado exitosamente");
                        this.setVisible(false);
                        ViewLogin.obtenerVentanaLogin(this.thread).setVisible(true);
                    }
                } catch (ClassNotFoundException ex) {
                ex.printStackTrace();
                } catch (SQLException ex) {
                ex.printStackTrace();
                }
            }
        }
        
        
    }//GEN-LAST:event_btnRegistrarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.setVisible(false);
        ViewLogin.obtenerVentanaLogin(this.thread).setVisible(true);
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPasswordField pswContrasenia;
    private javax.swing.JPasswordField pswContrasenia2;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables

    public static ViewRegister getVentanaRegister() {
        return ventanaRegister;
    }

    public static void setVentanaRegister(ViewRegister ventanaRegister) {
        ViewRegister.ventanaRegister = ventanaRegister;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
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

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JPasswordField getPswContrasenia() {
        return pswContrasenia;
    }

    public void setPswContrasenia(JPasswordField pswContrasenia) {
        this.pswContrasenia = pswContrasenia;
    }

    public JPasswordField getPswContrasenia2() {
        return pswContrasenia2;
    }

    public void setPswContrasenia2(JPasswordField pswContrasenia2) {
        this.pswContrasenia2 = pswContrasenia2;
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
        getPswContrasenia2().setText("");
        super.setVisible(b); //To change body of generated methods, choose Tools | Templates.
    }
}
