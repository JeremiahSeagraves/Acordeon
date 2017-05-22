/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.login.ViewLogin;
import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import server.ManagersConcepts;
import server.iManagerConcept;
import server.iManagerTopic;
import server.iManagersConcepts;
import server.iManagersLogs;
import server.iManagersTopics;

/**
 *
 * @author Milka
 */
public class ThreadAcordeon extends Thread {

    private final iManagersTopics managersTopics;
    private final iManagersConcepts managersConcepts;
    private final iManagersLogs managerLogs;

    public ThreadAcordeon(iManagersTopics managersTopics, iManagersConcepts managersConcepts, iManagersLogs managersLogs) {
        this.managersTopics = managersTopics;
        this.managersConcepts = managersConcepts;
        this.managerLogs = managersLogs;
    }

    public iManagersTopics getManagerTopics() {
        return managersTopics;
    }

    public iManagersConcepts getManagerConcepts() {
        return managersConcepts;
    }

    public iManagersLogs getManagerLogs() {
        return managerLogs;
    }

    public iManagerTopic getManagerTopic(int id) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            managersTopics.createManagerTopic(id);
            iManagerTopic manager = (iManagerTopic) registry.lookup("Topic" + id);
            return manager;
        } catch (RemoteException ex) {
            Logger.getLogger(ThreadAcordeon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ThreadAcordeon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public iManagerConcept getManagerConcept(int id) {
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1");
            managersConcepts.createManagerConcept(id);
            iManagerConcept manager = (iManagerConcept) registry.lookup("Concept" + id);
            return manager;
        } catch (RemoteException ex) {
            Logger.getLogger(ThreadAcordeon.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NotBoundException ex) {
            Logger.getLogger(ThreadAcordeon.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void run() {
        ViewLogin view = ViewLogin.obtenerVentanaLogin(this);
    }
}
