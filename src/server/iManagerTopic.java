/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import models.Topic;

/**
 *
 * @author practica1.sistemas
 */
public interface iManagerTopic extends Remote{
    public int getidTopic()throws RemoteException;
    public Topic readTopic(int id)throws RemoteException;
    public Topic previewmodifyTopic(int id)throws RemoteException;
    public void finalizemodifyTopic(Topic topic)throws RemoteException;
    public void deleteTopic(int id)throws RemoteException;
    public void createTopic(Topic topic)throws RemoteException;
    public void cancelLock()throws RemoteException;
}
