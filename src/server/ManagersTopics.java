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
import topics.models.Topic;

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
}
