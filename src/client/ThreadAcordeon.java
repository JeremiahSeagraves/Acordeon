/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import client.login.ViewLogin;
import server.iManagersConcepts;
import server.iManagersLogs;
import server.iManagersTopics;

/**
 *
 * @author Milka
 */
public class ThreadAcordeon extends Thread{
    private  iManagersTopics managersTopics;
    private  iManagersConcepts managerConcepts;
    private  iManagersLogs managerLogs;
    
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
    
/*    public DAOTopic getManagerTopics(){
        return new DAOTopic();
    }
    
    public DAOConcept getManagerConcepts(){
        return new DAOConcept();
    }
    
    public DAOLog getManagerLogs(){
        return new DAOLog();
    }
*/
    
    
    @Override
    public void run(){
        ViewLogin view = ViewLogin.obtenerVentanaLogin(this);
    }
}
