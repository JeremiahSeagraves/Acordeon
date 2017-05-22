/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOTopic;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
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
public class ManagersTopics extends UnicastRemoteObject implements iManagersTopics {

    private static final long serialVersionUID = 1L;
    private DAOTopic daoTopic;

    public ManagersTopics() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<Topic> readAllTopics() throws RemoteException {
        ArrayList<Topic> listTopics = null;
        daoTopic = new DAOTopic();
        try {
            listTopics = daoTopic.getTopics();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listTopics;
    }

    @Override
    public ManagerTopic createManagerTopic(int idTopic) throws RemoteException {
        ManagerTopic manager = new ManagerTopic(idTopic);
        Registry registry = LocateRegistry.createRegistry(1099);
        registry.rebind("Topic"+idTopic, manager);
        return manager;
    }
}
