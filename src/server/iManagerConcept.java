/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import topics.models.Concept;

/**
 *
 * @author practica1.sistemas
 */
public interface iManagerConcept extends Remote{
    public int getidConcept()throws RemoteException;
    public Concept readConcept(String id)throws RemoteException;
    public Concept previewmodifyConcept(String id)throws RemoteException;
    public void finalizemodifyConcept(Concept concept)throws RemoteException;
    public boolean deleteConcept(int id)throws RemoteException;
    public void createConcept(Concept concept)throws RemoteException;
    public void cancelLock()throws RemoteException;
}
