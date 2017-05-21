/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client;

import server.iManagersConcepts;
import server.iManagersTopics;

/**
 *
 * @author Milka
 */
public class ThreadAcordeon extends Thread{
    private final iManagersTopics managersTopics;
    private final iManagersConcepts managerConcepts;
    
    public ThreadAcordeon(iManagersTopics managersTopics, iManagersConcepts managersConcepts){
        this.managersTopics = managersTopics;
        this.managerConcepts = managersConcepts;
    }
    
    public iManagersTopics getManagerTopics(){
        return managersTopics;
    }
    
    public iManagersConcepts getManagerConcepts(){
        return managerConcepts;
    }
    @Override
    public void run(){
        // aqui va la ejecución de las ventanas
    }
}
