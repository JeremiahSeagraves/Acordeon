/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import server.iManagersConcepts;
import server.iManagersTopics;

/**
 *
 * @author Milka
 */
public class Client {
    public static void main (String[] args) throws MalformedURLException{
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            iManagersTopics managerTopics = (iManagersTopics)registry.lookup("ManagerTopics");
            iManagersConcepts managerConcepts = (iManagersConcepts)registry.lookup("ManagerConcepts");
            ThreadAcordeon thread = new ThreadAcordeon(managerTopics, managerConcepts);
        }catch(NotBoundException nbe){
            nbe.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
