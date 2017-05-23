/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import database.DAOLog;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Log;



/**
 *
 * @author Milka
 */
public class ManagersLogs extends UnicastRemoteObject implements iManagersLogs{
    private static final long serialVersionUID = 1L;
    private DAOLog daoLog;

    public ManagersLogs() throws RemoteException{
        super();
    }
    @Override
    public ArrayList<Log> readAllLogs() throws RemoteException {
        ArrayList<Log> listLogs = null;
        daoLog = new DAOLog();
        try {
            listLogs = daoLog.getLog();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLogs;
    }

    @Override
    public ArrayList<Log> readAllLogsforUser(int id) throws RemoteException {
        ArrayList<Log> listLogs = null;
        daoLog = new DAOLog();
        try {
            listLogs = daoLog.getLogUsers(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLogs;
    }

    @Override
    public ArrayList<Log> readAllLogsforConceptOrTopic(String topic_concept) throws RemoteException {
        ArrayList<Log> listLogs = null;
        daoLog = new DAOLog();
        try {
            listLogs = daoLog.getLogConcepts_Topics(topic_concept);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagerTopic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listLogs;
    }

    @Override
    public void createLog(Log log, int idUser) throws RemoteException {
        try {
            daoLog = new DAOLog();
            daoLog.insertLog(log, idUser);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersLogs.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersLogs.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}