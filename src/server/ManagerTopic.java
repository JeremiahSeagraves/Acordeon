/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOTopic;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Topic;

/**
 *
 * @author Milka
 */
public class ManagerTopic extends UnicastRemoteObject implements Serializable, iManagerTopic  {

    private static final long serialVersionUID = 1L;
    private DAOTopic daoTopic;
    private final int idTopic;
    private Lock objectLock = new ReentrantLock();

    public ManagerTopic(int idTopic) throws RemoteException {
        super();
        this.idTopic = idTopic;
    }
    
    @Override
    public int getidTopic()throws RemoteException {
        return idTopic;
    }

    @Override
    public Topic readTopic(int id) throws RemoteException{
        daoTopic = new DAOTopic();
        Topic topic = null;
        try {
            topic = daoTopic.buscarTopico(id);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topic;
    }

    @Override
    public synchronized Topic previewmodifyTopic(int id)throws RemoteException {
        if(objectLock.tryLock()){
            System.out.println("Buscando el Topico...");
            daoTopic = new DAOTopic();
            Topic topic = null;
        try {
            topic = daoTopic.buscarTopico(id);
            return topic;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
//        }finally{
////            objectLock.unlock();
//        }
        return null;
    }

    @Override
    public synchronized void finalizemodifyTopic(Topic topic) throws RemoteException{
        System.out.println("modificando topico...");
        daoTopic = new DAOTopic();
        try {
//            objectLock.lock();
            daoTopic.actualizarTopico(topic);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            objectLock.unlock();
        }
    }

    @Override
    public synchronized void deleteTopic(int id) throws RemoteException{
        objectLock.lock();
        try {
                System.out.println("Comienza el proceso de eliminacion...");
                daoTopic = new DAOTopic();
                daoTopic.eliminarTopico(id);
                System.out.println("Termino el proceso de eliminacion...");
            } catch (SQLException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
            objectLock.unlock();
            }
    }

    @Override
    public void createTopic(Topic topic)throws RemoteException {
        daoTopic = new DAOTopic();
        try {
            daoTopic.insertarTopico(topic);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void cancelLock() throws RemoteException{
        objectLock.unlock();
    }
}
