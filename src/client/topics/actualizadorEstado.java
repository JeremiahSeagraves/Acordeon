/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.topics;

import database.DAOConcept;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juan
 */
public class actualizadorEstado extends Thread {
        
        private int idConcept;
        private int estado;
        private static actualizadorEstado act = null;
        
        private actualizadorEstado(int idConcept, int estado) {
            this.idConcept = idConcept;
            this.estado = estado;
        }
        
        public static actualizadorEstado obtenerAct(int id, int estado){
            if(act==null){
                act=new actualizadorEstado(id, estado);
            }
            return act;
        }

        public int getIdConcept() {
            return idConcept;
        }

        public void setIdConcept(int idConcept) {
            this.idConcept = idConcept;
        }

        public int getEstado() {
            return estado;
        }

        public void setEstado(int estado) {
            this.estado = estado;
        }
        
        @Override
    public void run(){
        DAOConcept accesoConceptos = new DAOConcept();   
        do{
        try {
                accesoConceptos.actualizarEstado(idConcept, estado);
            } catch (SQLException ex) {
                Logger.getLogger(ViewConcepts.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ViewConcepts.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                act.sleep(1000);
            } catch (InterruptedException ex) {
                act=null;
               break;
            }
        }while(true);
        
    }
        
    }
    
