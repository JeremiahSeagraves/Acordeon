/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.util.ArrayList;
import models.Log;

/**
 *
 * @author Milka
 */
public interface iManagersLogs {
    ArrayList<Log> readAllLogs() throws RemoteException;
    ArrayList<Log> readAllLogsforUser(int id) throws RemoteException;
    ArrayList<Log> readAllLogsforConceptOrTopic(String topic_concept) throws RemoteException;
}
