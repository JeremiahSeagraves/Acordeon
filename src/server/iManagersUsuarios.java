/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import Sesion.User;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Milka
 */
public interface iManagersUsuarios extends Remote{
    public User readUser(int id) throws RemoteException;
    public User validarUsuario(String nombre, String clave)throws RemoteException;
    public void insertarUsuario(User usuario)throws RemoteException;
}
