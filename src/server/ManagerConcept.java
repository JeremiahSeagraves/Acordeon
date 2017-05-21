/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOConcept;
import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.models.Concept;

/**
 *
 * @author Milka
 */
public class ManagerConcept implements Serializable{
    
    private static final long serialVersionUID = 1L;
    private DAOConcept daoConcept;
    private final int idConcept;
    private Lock objectLock = new ReentrantLock();
    
    public ManagerConcept(int idConcept){
        this.idConcept = idConcept;
    }
    
    public int getidConcept(){
        return idConcept;
    }
    
    public Concept readConcept(String id){
        daoConcept = new DAOConcept();
        Concept concept = null;
        try {
            concept = daoConcept.buscarConcepto(id);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return concept;
    }

    public synchronized Concept previewmodifyConcept(String id){
        if(objectLock.tryLock()){
            objectLock.lock();
            System.out.println("Buscando el Topico...");
            daoConcept = new DAOConcept();
            Concept concept = null;
            try {
                concept = daoConcept.buscarConcepto(id);
                return concept;
            } catch (SQLException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void finalizemodifyConcept(Concept concept){
        System.out.println("modificando topico...");
        daoConcept = new DAOConcept();
        try {
            daoConcept.actualizarConcepto(concept);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        objectLock.unlock();
    }

    public synchronized boolean deleteConcept(int id){
        if(objectLock.tryLock()){
            try {
                System.out.println("Comienza el proceso de eliminacion...");
                daoConcept = new DAOConcept();
                daoConcept.eliminarConcepto(id);
                System.out.println("Termino el proceso de eliminacion...");
                return true;
            }catch (SQLException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            }finally{
                objectLock.unlock();
            }
        }
        return false;
    }

    public void createConcept(Concept concept){
        daoConcept = new DAOConcept();
        try {
            daoConcept.insertarConcepto(concept);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    public void cancelLock(){
        objectLock.unlock();
    }
    
}
