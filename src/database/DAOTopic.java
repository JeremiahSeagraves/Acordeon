/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Topic;

/**
 *
 * @author juan
 */

public class DAOTopic extends AccesoBD {
    
    private static final String CLAVE_STRING = "ID_TOPIC";
    private static final String NOMBRE_STRING = "NAME";

    public ArrayList<Topic> getTopics( ) throws ClassNotFoundException, SQLException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
 
         consultaBD =  SELECT_STRING + "*" + FROM_STRING + "topics";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaTopics = sentenciaConsulta.executeQuery( consultaBD );
         
         ArrayList<Topic> topics= new ArrayList<>( );
         Topic topico;
        
         while ( resultadoConsultaTopics.next() ) {
            topico = new Topic(  Integer.parseInt(resultadoConsultaTopics.getString( CLAVE_STRING )),
                                    resultadoConsultaTopics.getString( NOMBRE_STRING ));
            
            topics.add(topico);
        }
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
        
         return topics;
    }
   
   
   public void insertarTopico( Topic topico ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = INSERT_STRING + INTO_STRING + "topics" + VALUES_STRING
                        +"("        + "null"                       + ", "
                        + "\""      + topico.getName()  + "\","      +
                                           "0"               +  ")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
         
    }
   
    public void eliminarTopico( int claveTopico ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = DELETE_STRING + FROM_STRING + "topics" + WHERE_STRING + CLAVE_STRING + " = \"" + claveTopico + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
    }
   
    
    public Topic buscarTopico( int claveTopico ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = SELECT_STRING + "*" + FROM_STRING + "topics" + WHERE_STRING + CLAVE_STRING + "= \"" + claveTopico + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaTopics = sentenciaConsulta.executeQuery( consultaBD );
         
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaTopics.next( );
         
         Topic topico = new Topic(  Integer.parseInt(resultadoConsultaTopics.getString( CLAVE_STRING )),
                                    resultadoConsultaTopics.getString( NOMBRE_STRING ),
                                    resultadoConsultaTopics.getInt("Bloqueado"));
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
        
         return topico;
    }
    
    
    public void actualizarTopico( Topic topicoModificado ) throws SQLException, ClassNotFoundException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = UPDATE_STRING + " topics " + SET_STRING + " " 
                 + NOMBRE_STRING + " = \"" + topicoModificado.getName( ) + "\" "
                 + WHERE_STRING + " " + CLAVE_STRING + " = \"" + topicoModificado.getId()+ "\"";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
       
    }
    
    public void actualizarEstado(int clave, int estado) throws SQLException, ClassNotFoundException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = UPDATE_STRING + " topics " + SET_STRING + " " 
                 + "Bloqueado" + " = \"" + estado + "\" "
                 + WHERE_STRING + " " + CLAVE_STRING + " = \"" + clave + "\"";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
    }

}