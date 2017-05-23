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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Topic;

/**
 *
 * @author Milka
 */
public class ManagersTopics extends UnicastRemoteObject implements Serializable  {

    private static final long serialVersionUID = 1L;
    private DAOTopic daoTopic;

    public ManagersTopics() throws RemoteException {
        super();
    }

    
    public Topic readTopic(int id) {
        daoTopic = new DAOTopic();
        Topic topic = null;
        try {
            topic = daoTopic.buscarTopico(id);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return topic;
    }

    public synchronized Topic previewmodifyTopic(int id) {
        System.out.println("Buscando el Topico...");
        daoTopic = new DAOTopic();
        Topic topic = null;
        try {
            topic = daoTopic.buscarTopico(id);
            return topic;
        } catch (SQLException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
//        }finally{
////            objectLock.unlock();
//        }
        return null;
    }

    public synchronized void finalizemodifyTopic(Topic topic) {
        System.out.println("modificando topico...");
        daoTopic = new DAOTopic();
        try {
//            objectLock.lock();
            daoTopic.actualizarTopico(topic);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized boolean deleteTopic(int id) {
        try {
                System.out.println("Comienza el proceso de eliminacion...");
                daoTopic = new DAOTopic();
                daoTopic.eliminarTopico(id);
                System.out.println("Termino el proceso de eliminacion...");
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
            }
        return false;
    }

    public void createTopic(Topic topic) {
        daoTopic = new DAOTopic();
        try {
            daoTopic.insertarTopico(topic);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<Topic> readAllTopics() throws RemoteException {
        ArrayList<Topic> listTopics = null;
        daoTopic = new DAOTopic();
        try {
            listTopics = daoTopic.getTopics();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersTopics.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTopics;
    }
}
