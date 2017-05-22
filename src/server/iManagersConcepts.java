/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import server.ManagerConcept;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import topics.models.Concept;

/**
 *
 * @author Milka
 */
public interface iManagersConcepts extends Remote{
    ArrayList<Concept> readAllConcepts() throws RemoteException;
    ArrayList<Concept> getConceptsofATopic(int idTopic) throws RemoteException;
    ManagerConcept createManagerConcept(int idConcept) throws RemoteException;
}
