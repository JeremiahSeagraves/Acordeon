/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.login.ViewLogin;
import java.rmi.RemoteException;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Topic;
import server.ManagerTopic;
import server.iManagersConcepts;
import server.iManagersLogs;
import server.iManagersTopics;

/**
 *
 * @author Milka
 */
public class ThreadAcordeon extends Thread{
    private final iManagersTopics managersTopics;
    private final iManagersConcepts managerConcepts;
    private final iManagersLogs managerLogs;
    
    public ThreadAcordeon(iManagersTopics managersTopics, iManagersConcepts managersConcepts, iManagersLogs managersLogs){
        this.managersTopics = managersTopics;
        this.managerConcepts = managersConcepts;
        this.managerLogs = managersLogs;
    }
    
    public iManagersTopics getManagerTopics(){
        return managersTopics;
    }
    
    public iManagersConcepts getManagerConcepts(){
        return managerConcepts;
    }
    
    public iManagersLogs getManagerLogs(){
        return managerLogs;
    }
    
    @Override
    public void run(){
        ViewLogin view = ViewLogin.obtenerVentanaLogin(this);
    }
}
