/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.controllers.iManagerTopic;

/**
 *
 * @author Milka
 */
public class Client {
    public static void main (String[] args){
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            iManagerTopic manager = (iManagerTopic)registry.lookup("PowerObject");
            System.out.println("Read Concept" + manager.readConcept(2));
        }catch(NotBoundException nbe){
            nbe.printStackTrace();
        } catch (RemoteException ex) {
            ex.printStackTrace();
        }
    }
}
