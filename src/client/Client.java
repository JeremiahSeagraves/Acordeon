/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.iManagersConcepts;
import server.iManagersTopics;
import server.iManagersLogs;

/**
 *
 * @author Milka
 */
public class Client {
    public static void main (String[] args) throws MalformedURLException{
        try {
            Registry registry = LocateRegistry.getRegistry("192.168.228.218",1099);
            iManagersTopics managerTopics = (iManagersTopics)registry.lookup("ManagerTopics");
            iManagersConcepts managerConcepts = (iManagersConcepts)registry.lookup("ManagerConcepts");
            iManagersLogs managerLogs = (iManagersLogs)registry.lookup("ManagerLogs");
            ThreadAcordeon thread = new ThreadAcordeon (managerTopics, managerConcepts, managerLogs);
            thread.start();
        } catch (RemoteException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
