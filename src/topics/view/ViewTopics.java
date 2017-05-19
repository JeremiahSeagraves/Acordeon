/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.view;

import database.DAOTopic;
import java.sql.SQLException;
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
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import login.view.ViewLogin;
import topics.models.Topic;

/**
 *
 * @author juan
 */
public class ViewTopics extends javax.swing.JFrame {

    /**
     * Creates new form ViewTopics
     */
    
    private ArrayList<Topic> topicos;
    
    private ViewTopics() {
        initComponents();
    }
    
    private static ViewTopics ventanaTopicos = null;
     
    public static ViewTopics obtenerVentanaTopicos (){
        if(ventanaTopicos == null){
            ventanaTopicos = new ViewTopics();
            return ventanaTopicos;
        }
        
        return ventanaTopicos;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem1 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTemas = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        btnEntrar = new javax.swing.JButton();
        btnModificarTema = new javax.swing.JButton();
        btnEliminarTema = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        btnMenuAgregar = new javax.swing.JMenu();
        btnAgregarTema = new javax.swing.JMenuItem();
        menuCuenta = new javax.swing.JMenu();
        menuItemCerrarSesión = new javax.swing.JMenuItem();

        jMenuItem1.setText("jMenuItem1");

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

        menuItemCerrarSesión.setText("Cerrar sesión");
        menuItemCerrarSesión.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuItemCerrarSesiónActionPerformed(evt);
            }
        });
        menuCuenta.add(menuItemCerrarSesión);

        jMenuBar1.add(menuCuenta);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
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
                .addContainerGap()
                .addComponent(jLabel1)
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

    private void menuItemCerrarSesiónActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuItemCerrarSesiónActionPerformed
        JOptionPane.showMessageDialog(this, "Sesión cerrada", "Sesión", JOptionPane.INFORMATION_MESSAGE);
        this.setVisible(false);
        ViewLogin.obtenerVentanaLogin().setVisible(true);
    }//GEN-LAST:event_menuItemCerrarSesiónActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        int temaSeleccionado = getTablaTemas().getSelectedRow();
        if(temaSeleccionado>-1){
            String nombreTemaSeleccionado = topicos.get(temaSeleccionado).getName();
            ViewConcepts.obtenerVentanaConceptos().getLblTituloTema().setText(nombreTemaSeleccionado);
            ViewConcepts.obtenerVentanaConceptos().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado un tema", "Error",JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnModificarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTemaActionPerformed
        int temaSeleccionado = getTablaTemas().getSelectedRow();
        if(temaSeleccionado>-1){
            String nombreTemaSeleccionado = topicos.get(temaSeleccionado).getName();
            int idTemaSeleccionado = topicos.get(temaSeleccionado).getId();
            ViewModifyTopic.obtenerVentanaModificarTopico().getLblModificarTema().setText(nombreTemaSeleccionado);
            ViewModifyTopic.obtenerVentanaModificarTopico().getLblIdTopic().setText(String.valueOf(idTemaSeleccionado));
            ViewModifyTopic.obtenerVentanaModificarTopico().setVisible(true);
        }else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado un tema", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarTemaActionPerformed

    private void btnEliminarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTemaActionPerformed
         int temaSeleccionado = getTablaTemas().getSelectedRow();
        if(temaSeleccionado>-1){
            
            //AQUÍ SE VALIDA SI ERES QUIÉN LO CREÓ
            
            String nombreTemaSeleccionado = topicos.get(temaSeleccionado).getName();
            boolean respuesta = JOptionPane.showConfirmDialog(this, "¿Seguro que desea eliminar "+nombreTemaSeleccionado+"?"
                                            ,"Confirmación",JOptionPane.YES_NO_OPTION)==0?true:false;
            if(respuesta){
                try {
                    DAOTopic accesoTemas = new DAOTopic();
                    accesoTemas.eliminarTopico(topicos.get(temaSeleccionado).getId());
                } catch (SQLException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                }
                ViewTopics.obtenerVentanaTopicos().setVisible(respuesta);
                
            }
        }else{
            JOptionPane.showMessageDialog(this,"No ha seleccionado un tema", "Error",JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnEliminarTemaActionPerformed

    private void btnAgregarTemaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarTemaActionPerformed
       
            String nuevoTema =JOptionPane.showInputDialog(this, "Ingresa el nombre del nuevo tema",
                    "Nombre del nuevo tema");
            try{
            if(!nuevoTema.equals("")){
                Topic nuevoTopico = new Topic(nuevoTema);
                DAOTopic accesoTemas = new DAOTopic();
                try {
                    accesoTemas.insertarTopico(nuevoTopico);
                } catch (SQLException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
                }
                ViewTopics.obtenerVentanaTopicos().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(this, "No ingresó el nombre del nuevo tema", 
                                            "Error",JOptionPane.WARNING_MESSAGE);
            }
            }catch(NullPointerException e){
            }
    }//GEN-LAST:event_btnAgregarTemaActionPerformed
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
            java.util.logging.Logger.getLogger(ViewTopics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewTopics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewTopics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewTopics.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewTopics().setVisible(true);
            }
        });
    }
    
    private void cargarTopicos(){
        DAOTopic accesoTopicos = new DAOTopic();
        try {
            topicos = accesoTopicos.getTopics();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ViewTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void llenarTablaTemas(ArrayList<Topic> topicos){
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
    
    private DefaultTableModel obtenerModeloTabla (){
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
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenu menuCuenta;
    private javax.swing.JMenuItem menuItemCerrarSesión;
    private javax.swing.JTable tablaTemas;
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

    public JMenuItem getMenuItemCerrarSesión() {
        return menuItemCerrarSesión;
    }

    public void setMenuItemCerrarSesión(JMenuItem menuItemCerrarSesión) {
        this.menuItemCerrarSesión = menuItemCerrarSesión;
    }

    public JTable getTablaTemas() {
        return tablaTemas;
    }

    public void setTablaTemas(JTable tablaTemas) {
        this.tablaTemas = tablaTemas;
    }
}
