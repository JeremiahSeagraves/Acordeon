/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import models.Topic;

/**
 *
 * @author Milka
 */
public interface iManagersTopics extends Remote{
     ArrayList<Topic> readAllTopics() throws RemoteException;
     ManagerTopic getManagerTopic(int idTopic)throws RemoteException;
     void createTopic(Topic topic, int id)throws RemoteException;
     boolean deleteTopic(int id) throws RemoteException;
     Topic readTopic(int id) throws RemoteException;
     Topic previewmodifyTopic(int id) throws RemoteException;
     void finalizemodifyTopic(Topic topic, int id) throws RemoteException;
     
}
