/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.Remote;
import models.Topic;

/**
 *
 * @author practica1.sistemas
 */
public interface iManagerTopic extends Remote{
    public int getidTopic();
    public Topic readTopic(int id);
    public Topic previewmodifyTopic(int id);
    public void finalizemodifyTopic(Topic topic);
    public boolean deleteTopic(int id);
    public void createTopic(Topic topic);
    public void cancelLock();
}
