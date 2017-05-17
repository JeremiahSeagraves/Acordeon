package server;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import topics.controllers.ManagerTopic;

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
            Registry registry = LocateRegistry.createRegistry(1099);
            ManagerTopic managerTopic = new ManagerTopic();
            registry.rebind("PowerObject", managerTopic);
            
            System.out.println("Server starts... ");
        }
        catch(RemoteException e){
            e.printStackTrace();
        }
    }
}
