/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import topics.models.Concept;

/**
 *
 * @author juan
 */
public class ViewReadConcept extends javax.swing.JFrame {

    /**
     * Creates new form ViewReadConcept
     */
    private ViewReadConcept() {
        initComponents();
        setSize(450,370);
        setLocation(820, 0);
        getLblIdConcept().setVisible(false);
        txtDefinicion.setLineWrap(true);
        txtDefinicion.setWrapStyleWord(true);
    }
    
    private static ViewReadConcept ventanaLeerConcepto = null;
     
    public static ViewReadConcept obtenerVentanaLeerConcepto (){
        if(ventanaLeerConcepto == null){
            ventanaLeerConcepto = new ViewReadConcept();
            return ventanaLeerConcepto;
        }
        return ventanaLeerConcepto;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTema = new javax.swing.JLabel();
        lblConcepto = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtDefinicion = new javax.swing.JTextArea();
        lblUsuarioLogeado = new javax.swing.JLabel();
        lblIdConcept = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lblTema.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblTema.setText("Tema: ...");
        getContentPane().add(lblTema, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 21, -1, -1));

        lblConcepto.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        lblConcepto.setText("Concepto: ...");
        getContentPane().add(lblConcepto, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 67, -1, -1));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setText("Definición");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 115, -1, -1));

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        getContentPane().add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 287, -1, -1));

        txtDefinicion.setEditable(false);
        txtDefinicion.setColumns(20);
        jScrollPane3.setViewportView(txtDefinicion);

        getContentPane().add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(129, 115, 234, 154));

        lblUsuarioLogeado.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        getContentPane().add(lblUsuarioLogeado, new org.netbeans.lib.awtextra.AbsoluteConstraints(225, 0, 138, 20));
        getContentPane().add(lblIdConcept, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if(false){
            //SE VERIFICA QUE NADIE ESTÉ MODIFICANDO/LEYENDO
        }else{
            String concepto = getLblConcepto().getText();
            String descripcion = getTxtDefinicion().getText();
            int idConceptoSeleccionado = Integer.parseInt(getLblIdConcept().getText());
            ViewModifyConcept.obtenerVentanaModificarConcepto().getLblModificarConcepto().setText("Modificar "+concepto);
            ViewModifyConcept.obtenerVentanaModificarConcepto().getLblIdConcept().setText(String.valueOf(idConceptoSeleccionado));
            ViewModifyConcept.obtenerVentanaModificarConcepto().getLblUsuarioLogeado().setText(getLblUsuarioLogeado().getText());
            ViewModifyConcept.obtenerVentanaModificarConcepto().getTxtDefinicion().setText(descripcion);
            this.setVisible(false);
            ViewModifyConcept.obtenerVentanaModificarConcepto().setVisible(true);
            
        }
    }//GEN-LAST:event_btnModificarActionPerformed

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
            java.util.logging.Logger.getLogger(ViewReadConcept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewReadConcept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewReadConcept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewReadConcept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewReadConcept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblConcepto;
    private javax.swing.JLabel lblIdConcept;
    private javax.swing.JLabel lblTema;
    private javax.swing.JLabel lblUsuarioLogeado;
    private javax.swing.JTextArea txtDefinicion;
    // End of variables declaration//GEN-END:variables

    public static ViewReadConcept getVentanaLeerConcepto() {
        return ventanaLeerConcepto;
    }

    public static void setVentanaLeerConcepto(ViewReadConcept ventanaLeerConcepto) {
        ViewReadConcept.ventanaLeerConcepto = ventanaLeerConcepto;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }

    public void setBtnModificar(JButton btnModificar) {
        this.btnModificar = btnModificar;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public void setjLabel4(JLabel jLabel4) {
        this.jLabel4 = jLabel4;
    }

    public JScrollPane getjScrollPane3() {
        return jScrollPane3;
    }

    public void setjScrollPane3(JScrollPane jScrollPane3) {
        this.jScrollPane3 = jScrollPane3;
    }

    public JLabel getLblIdConcept() {
        return lblIdConcept;
    }

    public void setLblIdConcept(JLabel lblIdConcept) {
        this.lblIdConcept = lblIdConcept;
    }

    public JLabel getLblUsuarioLogeado() {
        return lblUsuarioLogeado;
    }

    public void setLblUsuarioLogeado(JLabel lblUsuarioLogeado) {
        this.lblUsuarioLogeado = lblUsuarioLogeado;
    }

    public JTextArea getTxtDefinicion() {
        return txtDefinicion;
    }

    public void setTxtDefinicion(JTextArea txtDefinicion) {
        this.txtDefinicion = txtDefinicion;
    }

    public JLabel getLblConcepto() {
        return lblConcepto;
    }

    public void setLblConcepto(JLabel lblConcepto) {
        this.lblConcepto = lblConcepto;
    }

    public JLabel getLblTema() {
        return lblTema;
    }

    public void setLblTema(JLabel lblTema) {
        this.lblTema = lblTema;
    }
}
