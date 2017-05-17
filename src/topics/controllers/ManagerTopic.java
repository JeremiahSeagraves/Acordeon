/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.controllers;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import topics.models.Concept;
import topics.models.Topic;

/**
 *
 * @author Milka
 */
public class ManagerTopic extends UnicastRemoteObject implements iManagerTopic{
    private static final long serialVersionUID = 1L;
    public ManagerTopic() throws RemoteException {
        super();
    }

    @Override
    public Topic readTopic(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Topic modifyTopic(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Topic deleteTopic(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Topic createTopic(Topic topic) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concept readConcept(int id) throws RemoteException {
        Concept concept = new Concept(2, "Hola", "Es el libro Hola", 5);
        return concept;
    }

    @Override
    public Concept modifyConcept(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concept deleteConcept(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Concept createConcept(Concept concept) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
