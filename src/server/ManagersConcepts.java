/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOConcept;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.models.Concept;

/**
 *
 * @author Milka
 */
public class ManagersConcepts extends UnicastRemoteObject implements iManagersConcepts{
    
    private static final long serialVersionUID = 1L;
    private DAOConcept daoConcept;
    private ArrayList<ManagerConcept> listManagers;
    
    public ManagersConcepts() throws RemoteException {
        super();
        listManagers = new ArrayList<>();
    }

    @Override
    public ArrayList<Concept> readAllConcepts() throws RemoteException {
        ArrayList<Concept> listConcepts = null;
        daoConcept = new DAOConcept();
        try {
            listConcepts = daoConcept.getConcepts();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listConcepts;
    }
    
    private ManagerConcept createManagerConcept(int idConcept) throws RemoteException{
        ManagerConcept manager = new ManagerConcept(idConcept);
        listManagers.add(manager);
        return manager;
    }
    
    @Override
    public ManagerConcept getManagerConcept(int idConcept) throws RemoteException {
        for (int i = 0; i < listManagers.size(); i++) {
            if(listManagers.get(i).getidConcept() == idConcept){
                return listManagers.get(i);
            }
        }
        return createManagerConcept(idConcept);
    }
    
    @Override
    public ArrayList<Concept> getConceptsofATopic(int idTopic) throws RemoteException{
        ArrayList<Concept> listConcepts = null;
        daoConcept = new DAOConcept();
        try{
            listConcepts = daoConcept.getConceptsofATopic(idTopic);
            return listConcepts;
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
