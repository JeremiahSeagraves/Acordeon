/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import models.Sesion.User;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import topics.models.Concept;

/**
 *
 * @author juan
 */
public class DAOUser extends AccesoBD {
    
    private static final String CLAVE_STRING = "ID_USER";
    private static final String NOMBRE_STRING = "NAME";
    private static final String PASSWORD_STRING = "PASSWORD";
    
    public User getUser(int id)throws ClassNotFoundException{
        try{
            ConnectionHandler.obtenerInstancia( ).conectarConBD( );
            conexionBD = ConnectionHandler.obtenerConexion( );
            
            consultaBD = SELECT_STRING + "*" + FROM_STRING + "users" + WHERE_STRING + CLAVE_STRING + "= \"" + id + "\"";
            sentenciaConsulta = conexionBD.createStatement( );
            ResultSet resultadoConsultaConcepts = sentenciaConsulta.executeQuery( consultaBD );
            
            //Omite el primero elemento del ResultSet el cual es una dirección de memoria
            resultadoConsultaConcepts.next( );
            
            User usuario = new User(  Integer.parseInt(resultadoConsultaConcepts.getString( CLAVE_STRING )),
                    resultadoConsultaConcepts.getString( NOMBRE_STRING ),
                    resultadoConsultaConcepts.getString( PASSWORD_STRING ));
            
            ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
            
            return usuario;
        } catch (SQLException ex) {
        }
        return null;
        }
    
    
     public User validarUsuario( String nombre, String clave ) throws  ClassNotFoundException {
        try {
            System.out.println(" no entra");
            ConnectionHandler.obtenerInstancia( ).conectarConBD( );
            System.out.println("no ");
            conexionBD = ConnectionHandler.obtenerConexion( );
            
            consultaBD = SELECT_STRING + "*" + FROM_STRING + "users" + WHERE_STRING + NOMBRE_STRING + "= \"" + nombre + "\""
                    +"AND PASSWORD = \""+clave+"\"";
            sentenciaConsulta = conexionBD.createStatement( );
            ResultSet resultadoConsultaConcepts = sentenciaConsulta.executeQuery( consultaBD );
            
            //Omite el primero elemento del ResultSet el cual es una dirección de memoria
            resultadoConsultaConcepts.next( );
            
            User usuario = new User(  Integer.parseInt(resultadoConsultaConcepts.getString( CLAVE_STRING )),
                    resultadoConsultaConcepts.getString( NOMBRE_STRING ),
                    resultadoConsultaConcepts.getString( PASSWORD_STRING ));
            
            ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
            
            return usuario;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
     
    public void insertarUsuario( User usuario ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = INSERT_STRING + INTO_STRING + "users" + VALUES_STRING
                        +"("        + "null"                       + ", "
                        + "\""      + usuario.getName()            + "\", "
                        + "\""      +usuario.getPassword()         + "\")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
         
    }
}
