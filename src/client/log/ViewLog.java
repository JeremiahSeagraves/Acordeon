/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.log;

import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import models.Log;

/**
 *
 * @author Milka
 */
public class ViewLog extends javax.swing.JFrame {

    private String order;
    private static ViewLog viewLog = null;
    
    private ViewLog(ArrayList<Log> listLog, String order) {
        initComponents();
        this.order = order;
        llenarTablaConceptos(listLog);
    }
    
    public static ViewLog obtenerVentanaLog(ArrayList<Log> listLog, String order){
        if(viewLog == null){
            viewLog = new ViewLog(listLog, order);
            viewLog.setVisible(true);
            return viewLog;
        }
        viewLog.setVisible(true);
        return viewLog;
    }
    private void llenarTablaConceptos(ArrayList<Log> listLogs){
        obtenerModeloTabla().setRowCount(0);
        Collections.sort(listLogs);
         for (int numTopico = 0; numTopico < listLogs.size(); numTopico++) {
            obtenerModeloTabla().addRow(new Object[]{
                listLogs.get(numTopico).getId(),
                listLogs.get(numTopico).getMovType(),
                listLogs.get(numTopico).getObjType(),
                listLogs.get(numTopico).getDate(),
                listLogs.get(numTopico).getHour(),
                listLogs.get(numTopico).getUser()
                });
        }
         getTablaLogs().setModel(obtenerModeloTabla());
     }
    
    private DefaultTableModel obtenerModeloTabla (){
        return (DefaultTableModel) getTablaLogs().getModel();
    }

    public JTable getTablaLogs() {
        return tablaLogs;
    }

    public void setTablaLogs(JTable tablaLogs) {
        this.tablaLogs = tablaLogs;
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLogs = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tablaLogs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Tipo de movimiento", "Tipo de objeto", "Fecha", "Hora", "Nombre de usuario"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaLogs);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel1.setText("Bitácora");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLogs;
    // End of variables declaration//GEN-END:variables
}
