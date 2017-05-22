/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOConcept;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.models.Concept;

/**
 *
 * @author Milka
 */
public class ManagerConcept implements Serializable, iManagerConcept{
    
    private static final long serialVersionUID = 1L;
    private DAOConcept daoConcept;
    private final int idConcept;
    private Lock objectLock = new ReentrantLock();
    
    public ManagerConcept(int idConcept){
        this.idConcept = idConcept;
    }
    
    @Override
    public int getidConcept()throws RemoteException{
        return idConcept;
    }
    
    @Override
    public Concept readConcept(String id)throws RemoteException{
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

    @Override
    public synchronized Concept previewmodifyConcept(String id)throws RemoteException{
        if(objectLock.tryLock()){
            try {
                System.out.println("Buscando el Topico...");
                daoConcept = new DAOConcept();
                Concept concept = null;
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

    @Override
    public void finalizemodifyConcept(Concept concept)throws RemoteException{
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

    @Override
    public synchronized boolean deleteConcept(int id)throws RemoteException{
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

    @Override
    public void createConcept(Concept concept)throws RemoteException{
        daoConcept = new DAOConcept();
        try {
            daoConcept.insertarConcepto(concept);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
    @Override
    public void cancelLock()throws RemoteException{
        objectLock.unlock();
    }

}
