package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Milka
 */
public class Server {
    public static void main (String[] args){
        try{
            System.setProperty("java.rmi.server.hostname", "192.168.228.218");
            Registry registry = LocateRegistry.createRegistry(1099);
            ManagersTopics managersTopics = new ManagersTopics();
            ManagersConcepts managersConcepts = new ManagersConcepts();
            ManagersUsers managersUsers = new ManagersUsers();
            ManagersLogs managersLogs = new ManagersLogs();
            registry.rebind("ManagerTopics", managersTopics);
            registry.rebind("ManagerConcepts", managersConcepts);
            registry.rebind("ManagersUsers", managersUsers);
            registry.rebind("ManagerLogs", managersLogs);
            
            System.out.println("Server starts... ");
        }
        catch(RemoteException e){
        }
    }
}
