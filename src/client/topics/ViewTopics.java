/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import Sesion.User;
import client.ThreadAcordeon;
import client.log.ViewLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import client.login.ViewLogin;
import java.rmi.RemoteException;
import java.sql.Time;
import java.util.Date;
import models.Log;
import topics.models.Concept;
import models.Topic;
import server.ManagerTopic;

/**
 *
 * @author juan
 */
public class ViewTopics extends javax.swing.JFrame {

    private User user;
    private ThreadAcordeon thread;
    private ArrayList<Topic> topicos;

    private ViewTopics(ThreadAcordeon thread, User user) {
        this.user = user;
        initComponents();
        this.thread = thread;
    }

    private static ViewTopics ventanaTopicos = null;

    public static ViewTopics obtenerVentanaTopicos(ThreadAcordeon thread, User user) {
        if (ventanaTopicos == null) {
            ventanaTopicos = new ViewTopics(thread, user);
            ventanaTopicos.setVisible(true);
            return ventanaTopicos;
        }
        ventanaTopicos.setVisible(true);
        return ventanaTopicos;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnModificarTema = new javax.swing.JButton();
        btnEliminarTema = new javax.swing.JButton();
        lblUsuarioLogeado = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuAgregar = new javax.swing.JMenu();
        btnAgregarTema = new javax.swing.JMenuItem();
        menuCuenta = new javax.swing.JMenu();
        menuItemCerrarSesiion = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        verBitacora = new javax.swing.JMenuItem();
        verBitacoraUsuario = new javax.swing.JMenuItem();
        verBitacoraTemas = new javax.swing.JMenuItem();
        veBitacoraConceptos = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

        jMenuItem2.setText("jMenuItem2");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Temas");

        tablaTemas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tema"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTemas);
        if (tablaTemas.getColumnModel().getColumnCount() > 0) {
            tablaTemas.getColumnModel().getColumn(0).setMinWidth(30);
            tablaTemas.getColumnModel().getColumn(0).setPreferredWidth(50);
            tablaTemas.getColumnModel().getColumn(0).setMaxWidth(80);
        }

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Temas");

        btnEntrar.setText("Entrar");
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        btnModificarTema.setText("Modificar");
        btnModificarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTemaActionPerformed(evt);
            }
        });

        btnEliminarTema.setText("Eliminar");
        btnEliminarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTemaActionPerformed(evt);
            }
        });

        lblUsuarioLogeado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);

        btnMenuAgregar.setText("Agregar");

        btnAgregarTema.setText("Agregar tema");
        btnAgregarTema.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarTemaActionPerformed(evt);
            }
        });
        btnMenuAgregar.add(btnAgregarTema);

        jMenuBar1.add(btnMenuAgregar);

        menuCuenta.setText("Sesión");

        menuItemCerrarSesiion.setText("Cerrar sesión");
        menuItemCerrarSesiion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesiionActionPerformed(evt);
            }
        });
        menuCuenta.add(menuItemCerrarSesiion);

        jMenuBar1.add(menuCuenta);

        jMenu1.setText("Bitácora");

        verBitacora.setText("Ver bitácora");
        verBitacora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBitacoraActionPerformed(evt);
            }
        });
        jMenu1.add(verBitacora);

        verBitacoraUsuario.setText("Ver tu bitácora");
        verBitacoraUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBitacoraUsuarioActionPerformed(evt);
            }
        });
        jMenu1.add(verBitacoraUsuario);

        verBitacoraTemas.setText("Ver bitácora de los temas");
        verBitacoraTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verBitacoraTemasActionPerformed(evt);
            }
        });
        jMenu1.add(verBitacoraTemas);

        veBitacoraConceptos.setText("Ver bitácora de los conceptos");
        veBitacoraConceptos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                veBitacoraConceptosActionPerformed(evt);
            }
        });
        jMenu1.add(veBitacoraConceptos);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(btnEntrar)
                .addGap(56, 56, 56)
                .addComponent(btnModificarTema)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnEliminarTema)
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(lblUsuarioLogeado, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEntrar)
                    .addComponent(btnModificarTema)
                    .addComponent(btnEliminarTema))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuItemCerrarSesiionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesiionActionPerformed
        ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).setVisible(false);
        ViewReadConcept.obtenerVentanaLeerConcepto(this.thread, this.user).setVisible(false);
        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).setVisible(false);
        ViewModifyConcept.obtenerVentanaModificarConcepto(this.thread, this.user).setVisible(false);
        ViewAddConcept.obtenerVentanaAniadirConcepto(this.thread, this.user).setVisible(false);
        JOptionPane.showMessageDialog(this, "Sesión cerrada", "Sesión", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        ViewLogin.obtenerVentanaLogin(this.thread).setVisible(true);
    }//GEN-LAST:event_menuItemCerrarSesiionActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        int temaSeleccionado = getTablaTemas().getSelectedRow();
        if (temaSeleccionado > -1) {
            try {
                Topic temaSelec = topicos.get(temaSeleccionado);
                Topic seleccionado = thread.getManagerTopics().createManagerTopic(temaSelec.getId()).readTopic(temaSelec.getId());

                ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).getLblTituloTema().setText(seleccionado.getName());
                ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).getLblUsuarioLogeado().setText(user.getName());
                ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).getLblIdTopic().setText(String.valueOf(seleccionado.getId()));
                ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).setVisible(true);
            } catch (RemoteException ex) {
                Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado un tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnModificarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTemaActionPerformed
        int rowtemaSeleccionado = getTablaTemas().getSelectedRow();
        int id = topicos.get(rowtemaSeleccionado).getId();
        if (rowtemaSeleccionado > -1) {
            try {
                    ManagerTopic manager = thread.getManagerTopics().createManagerTopic(id);
                    if(manager!=null){
                        Topic temaSeleccionado = manager.previewmodifyTopic(topicos.get(rowtemaSeleccionado).getId());
                        String nombreTemaSeleccionado = temaSeleccionado.getName();
                        int idTemaSeleccionado = temaSeleccionado.getId();
                        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).setManager(manager);
                        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).getLblModificarTema().setText(nombreTemaSeleccionado);
                        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).getLblIdTopic().setText(String.valueOf(idTemaSeleccionado));
                        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).getLblUsuarioLogeado().setText(user.getName());
                        ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).setVisible(true);
                    }else{
                        JOptionPane.showMessageDialog(this, "No se puede modificar el objeto", "Error", JOptionPane.ERROR_MESSAGE);
                    }
            } catch (RemoteException ex) {
                Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado un tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarTemaActionPerformed

    private void btnEliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTemaActionPerformed
        int temaSeleccionado = getTablaTemas().getSelectedRow();
        if (temaSeleccionado > -1) {
            //AQUÍ SE VALIDA SI ERES QUIÉN LO CREÓ
            ViewConcepts.obtenerVentanaConceptos(this.thread, this.user).setVisible(false);
            ViewReadConcept.obtenerVentanaLeerConcepto(this.thread, this.user).setVisible(false);
            ViewModifyTopic.obtenerVentanaModificarTopico(this.thread, this.user).setVisible(false);
            ViewModifyConcept.obtenerVentanaModificarConcepto(this.thread, this.user).setVisible(false);
            ViewAddConcept.obtenerVentanaAniadirConcepto(this.thread, this.user).setVisible(false);
            String nombreTemaSeleccionado = topicos.get(temaSeleccionado).getName();
            boolean respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar " + nombreTemaSeleccionado + "?", "Confirmación", JOptionPane.YES_NO_OPTION) == 0 ? true : false;
            if (respuesta) {
                try {
                    ArrayList<Concept> conceptos = thread.getManagerConcepts().getConceptsofATopic(topicos.get(temaSeleccionado).getId());
                    if (conceptos.isEmpty()) {
                        thread.getManagerTopics().createManagerTopic(topicos.get(temaSeleccionado).getId()).deleteTopic(topicos.get(temaSeleccionado).getId());
                        Date date = new Date();
                        java.sql.Date datesql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
                        Time time = new Time(date.getHours(), date.getMinutes(), date.getSeconds());
                        Log log = new Log("eliminar", "tema", datesql, time, user.getName());
                        thread.getManagerLogs().createLog(log, user.getIdUser());
                    } else {
                        JOptionPane.showMessageDialog(this, "No se puede eliminar el tema. Tiene conceptos relacionados.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (RemoteException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                }
                ViewTopics.obtenerVentanaTopicos(thread, user).setVisible(respuesta);

            }
        } else {
            JOptionPane.showMessageDialog(this, "No ha seleccionado un tema", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTemaActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed

        String nuevoTema = JOptionPane.showInputDialog(this, "Ingresa el nombre del nuevo tema",
                "Nombre del nuevo tema");
        try {
            if (!nuevoTema.equals("")) {
                Topic nuevoTopico = new Topic(nuevoTema);
                try {
                    thread.getManagerTopics().createManagerTopic(0).createTopic(nuevoTopico);
                    Date date = new Date();
                    java.sql.Date datesql = new java.sql.Date(date.getYear(), date.getMonth(), date.getDay());
                    Time time = new Time(date.getHours(), date.getMinutes(), date.getSeconds());
                    Log log = new Log("alta", "tema", datesql, time, user.getName());
                    thread.getManagerLogs().createLog(log, user.getIdUser());
                } catch (RemoteException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                }
                ViewTopics.obtenerVentanaTopicos(thread, user).setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "No ingresó el nombre del nuevo tema",
                        "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NullPointerException e) {
        }
    }//GEN-LAST:event_btnAgregarTemaActionPerformed

    private void verBitacoraTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBitacoraTemasActionPerformed
        try {
            ViewLog ventanaLog = ViewLog.obtenerVentanaLog(thread.getManagerLogs().readAllLogsforConceptOrTopic("tema"), "temas");

        } catch (RemoteException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verBitacoraTemasActionPerformed

    private void verBitacoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBitacoraActionPerformed
        try {
            ViewLog ventanaLog = ViewLog.obtenerVentanaLog(thread.getManagerLogs().readAllLogs(), "ninguno");

        } catch (RemoteException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verBitacoraActionPerformed

    private void verBitacoraUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verBitacoraUsuarioActionPerformed
        try {
            ViewLog ventanaLog = ViewLog.obtenerVentanaLog(thread.getManagerLogs().readAllLogsforUser(user.getIdUser()), "usuario");

        } catch (RemoteException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_verBitacoraUsuarioActionPerformed

    private void veBitacoraConceptosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_veBitacoraConceptosActionPerformed
        try {
            ViewLog ventanaLog = ViewLog.obtenerVentanaLog(thread.getManagerLogs().readAllLogsforConceptOrTopic("concepto"), "concepto");

        } catch (RemoteException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_veBitacoraConceptosActionPerformed

    private void cargarTopicos() {
        try {
            topicos = thread.getManagerTopics().readAllTopics();
        } catch (RemoteException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void llenarTablaTemas(ArrayList<Topic> topicos) {
        obtenerModeloTabla().setRowCount(0);
        Collections.sort(topicos);
        for (int numTopico = 0; numTopico < topicos.size(); numTopico++) {
            obtenerModeloTabla().addRow(new Object[]{
                topicos.get(numTopico).getId(),
                topicos.get(numTopico).getName()
            });
        }
        getTablaTemas().setModel(obtenerModeloTabla());
    }

    private DefaultTableModel obtenerModeloTabla() {
        return (DefaultTableModel) getTablaTemas().getModel();
    }

    @Override
    public void setVisible(boolean b) {
        cargarTopicos();
        llenarTablaTemas(topicos);
        super.setVisible(b);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem btnAgregarTema;
    private javax.swing.JButton btnEliminarTema;
    private javax.swing.JButton btnEntrar;
    private javax.swing.JMenu btnMenuAgregar;
    private javax.swing.JButton btnModificarTema;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenuItem menuItemCerrarSesiion;
    private javax.swing.JTable tablaTemas;
    private javax.swing.JMenuItem veBitacoraConceptos;
    private javax.swing.JMenuItem verBitacora;
    private javax.swing.JMenuItem verBitacoraTemas;
    private javax.swing.JMenuItem verBitacoraUsuario;
    // End of variables declaration//GEN-END:variables

    public static ViewTopics getVentanaTopicos() {
        return ventanaTopicos;
    }

    public static void setVentanaTopicos(ViewTopics ventanaTopicos) {
        ViewTopics.ventanaTopicos = ventanaTopicos;
    }

    public JMenuItem getBtnAgregarTema() {
        return btnAgregarTema;
    }

    public void setBtnAgregarTema(JMenuItem btnAgregarTema) {
        this.btnAgregarTema = btnAgregarTema;
    }

    public JButton getBtnEliminarTema() {
        return btnEliminarTema;
    }

    public void setBtnEliminarTema(JButton btnEliminarTema) {
        this.btnEliminarTema = btnEliminarTema;
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public void setBtnEntrar(JButton btnEntrar) {
        this.btnEntrar = btnEntrar;
    }

    public JMenu getBtnMenuAgregar() {
        return btnMenuAgregar;
    }

    public void setBtnMenuAgregar(JMenu btnMenuAgregar) {
        this.btnMenuAgregar = btnMenuAgregar;
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

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public void setjMenuBar1(JMenuBar jMenuBar1) {
        this.jMenuBar1 = jMenuBar1;
    }

    public JMenuItem getjMenuItem1() {
        return jMenuItem1;
    }

    public void setjMenuItem1(JMenuItem jMenuItem1) {
        this.jMenuItem1 = jMenuItem1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public void setjScrollPane1(JScrollPane jScrollPane1) {
        this.jScrollPane1 = jScrollPane1;
    }

    public JMenu getMenuCuenta() {
        return menuCuenta;
    }

    public void setMenuCuenta(JMenu menuCuenta) {
        this.menuCuenta = menuCuenta;
    }

    public JMenuItem getMenuItemCerrarSesiion() {
        return menuItemCerrarSesiion;
    }

    public void setMenuItemCerrarSesiion(JMenuItem menuItemCerrarSesiion) {
        this.menuItemCerrarSesiion = menuItemCerrarSesiion;
    }

    public JTable getTablaTemas() {
        return tablaTemas;
    }

    public void setTablaTemas(JTable tablaTemas) {
        this.tablaTemas = tablaTemas;
    }

    public JLabel getLblUsuarioLogeado() {
        return lblUsuarioLogeado;
    }

    public void setLblUsuarioLogeado(JLabel lblUsuarioLogeado) {
        this.lblUsuarioLogeado = lblUsuarioLogeado;
    }

    public JMenuItem getVeBitacoraConceptos() {
        return veBitacoraConceptos;
    }

    public void setVeBitacoraConceptos(JMenuItem veBitacoraConceptos) {
        this.veBitacoraConceptos = veBitacoraConceptos;
    }

    public JMenuItem getVerBitacora() {
        return verBitacora;
    }

    public void setVerBitacora(JMenuItem verBitacora) {
        this.verBitacora = verBitacora;
    }

    public JMenuItem getVerBitacoraTemas() {
        return verBitacoraTemas;
    }

    public void setVerBitacoraTemas(JMenuItem verBitacoraTemas) {
        this.verBitacoraTemas = verBitacoraTemas;
    }

    public JMenuItem getVerBitacoraUsuario() {
        return verBitacoraUsuario;
    }

    public void setVerBitacoraUsuario(JMenuItem verBitacoraUsuario) {
        this.verBitacoraUsuario = verBitacoraUsuario;
    }

}
