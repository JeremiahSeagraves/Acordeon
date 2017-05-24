/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOTopic;
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
public class ManagersTopics extends UnicastRemoteObject implements iManagersTopics{
    private static final long serialVersionUID = 1L;
    private DAOTopic daoTopic;
    private ArrayList<ManagerTopic> listManagers;
    
    public ManagersTopics() throws RemoteException{
        super();
        listManagers = new ArrayList<>();
    }
    @Override
    public ArrayList<Topic> readAllTopics() throws RemoteException {
        ArrayList<Topic> listTopics = null;
        System.out.println("1");
        daoTopic = new DAOTopic();
        System.out.println("2");
        try {
            listTopics = daoTopic.getTopics();
            System.out.println(listTopics);
        } catch (ClassNotFoundException ex) {
            System.out.println("found");
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            System.out.println("sql");
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listTopics);
        return listTopics;
    }
    
    private ManagerTopic createManagerTopic(int idTopic) throws RemoteException{
        ManagerTopic manager = new ManagerTopic(idTopic);
        listManagers.add(manager);
        return manager;
    }
    @Override
    public ManagerTopic getManagerTopic(int idTopic) throws RemoteException{

        for (int i = 0; i < listManagers.size(); i++) {
            if(listManagers.get(i).getidTopic() == idTopic){
                return listManagers.get(i);
            }
        }
        return createManagerTopic(idTopic);
    }
    public void createTopic(Topic topic, int id) throws RemoteException{
        ManagerTopic manager = getManagerTopic(id);
        manager.createTopic(topic);
    }

    @Override
    public boolean deleteTopic(int id) throws RemoteException {
        ManagerTopic manager = getManagerTopic(id);
        return manager.deleteTopic(id);
    }

    @Override
    public Topic readTopic(int id) throws RemoteException {
        ManagerTopic manager = getManagerTopic(id);
        manager.readTopic(id);
        return manager.readTopic(id);
    }

    @Override
    public Topic previewmodifyTopic(int id) throws RemoteException {
        ManagerTopic manager = getManagerTopic(id);
        return manager.previewmodifyTopic(id);
    }

    @Override
    public void finalizemodifyTopic(Topic topic, int id) throws RemoteException {
        ManagerTopic manager = getManagerTopic(id);
        manager.deleteTopic(id);
    }
}

