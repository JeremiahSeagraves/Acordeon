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
    private ArrayList<ManagerTopic> listLockManagers;
    
    
    public ManagersTopics() throws RemoteException{
        super();
        listManagers = new ArrayList<>();
        listLockManagers = new ArrayList<>();
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
    public ManagerTopic getManagerTopic(int idTopic, boolean modify) throws RemoteException{
        if(islock(idTopic)){
            return null;
        }else{
            for (int i = 0; i < listManagers.size(); i++) {
                if(listManagers.get(i).getidTopic() == idTopic){
                    ManagerTopic manager = listManagers.get(i);
                    if(modify){
                        listManagers.remove(i);
                        lockManager(manager);
                    }
                    return manager;
                }
            }
            return createManagerTopic(idTopic);
        }
    }
    
    private void lockManager(ManagerTopic manager){
        listLockManagers.add(manager);
    }
    
    @Override
    public void unlockManager(int id) throws RemoteException{
        for (int i = 0; i < listLockManagers.size(); i++) {
            if(listLockManagers.get(i).getidTopic() == id){
                ManagerTopic manager = listLockManagers.get(i);
                listLockManagers.remove(i);
                listManagers.add(manager);
            }
        }
    }
    
    private boolean islock(int id){
        for (int i = 0; i < listLockManagers.size(); i++) {
            if(listLockManagers.get(i).getidTopic() == id){
                return true;
            }
        }
        return false;
    }
    
}
