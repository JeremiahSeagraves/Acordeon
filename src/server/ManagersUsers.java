/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import models.Sesion.User;
import database.DAOUser;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Milka
 */
public class ManagersUsers extends UnicastRemoteObject implements iManagersUsuarios{
    private static final long serialVersionUID = 1L;
    private DAOUser daoUser;

    public ManagersUsers() throws RemoteException {
        super();
    }
    
    
    @Override
    public User readUser(int id) throws RemoteException {
        User user = null;
        daoUser = new DAOUser();
        try {
            user = daoUser.getUser(id);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public User validarUsuario(String nombre, String clave) throws RemoteException {
        User user = null;
        daoUser = new DAOUser();
        try {
            user = daoUser.validarUsuario(nombre, clave);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
        return user;
    }

    @Override
    public void insertarUsuario(User usuario) throws RemoteException {
        
        try {
            daoUser = new DAOUser();
            daoUser.insertarUsuario(usuario);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManagersUsers.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManagersUsers.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
