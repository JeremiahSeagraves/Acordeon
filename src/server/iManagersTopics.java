/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.ManagerTopic;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import topics.models.Topic;

/**
 *
 * @author Milka
 */
public interface iManagersTopics extends Remote{
     ArrayList<Topic> readAllTopics() throws RemoteException;
     ManagerTopic getManagerTopic(int idTopic)throws RemoteException;
}
