/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import Sesion.User;
import static database.AccesoBD.FROM_STRING;
import static database.AccesoBD.SELECT_STRING;
import static database.AccesoBD.conexionBD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import models.Log;

/**
 *
 * @author Milka
 */
public class DAOLog extends AccesoBD{
    private static final String CLAVE_LOG = "ID_LOG";
    private static final String MOV_TYPE = "MOV_TYPE";
    private static final String NAME_OBJ = "NAME_OBJ";
    private static final String DATE = "DATE";
    private static final String HOUR = "HOUR";
    private static final String ID_USER = "ID_USER";
    
    public void insertLog(Log log, int idUser)throws ClassNotFoundException,SQLException{
        ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = INSERT_STRING + INTO_STRING + "log" + VALUES_STRING
                        +"("        + "null"                       + ", "
                        + "\""      + log.getMovType()             + "\", "
                        + "\""      + log.getObjType()             + "\", "
                        + "\""      + log.getDate()                + "\", "
                        + "\""      + log.getHour()                + "\", "
                        + "\""      + idUser                       + "\")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
    }
    
    public ArrayList<Log> getLog() throws ClassNotFoundException, SQLException{
        ConnectionHandler.obtenerInstancia( ).conectarConBD( );
        conexionBD = ConnectionHandler.obtenerConexion( );

        consultaBD = SELECT_STRING + "*" + FROM_STRING + "log";
        sentenciaConsulta = conexionBD.createStatement( );
        ResultSet resultadoConsultaLogs = sentenciaConsulta.executeQuery( consultaBD );
        
        ArrayList<Log> logs= new ArrayList<>( );
        Log log;
        
        DAOUser daoUser = new DAOUser();
        User user = daoUser.getUser(resultadoConsultaLogs.getInt(ID_USER));
        
        while ( resultadoConsultaLogs.next() ) {
            log = new Log(resultadoConsultaLogs.getInt(CLAVE_LOG),
                          resultadoConsultaLogs.getString(MOV_TYPE),
                          resultadoConsultaLogs.getString(NAME_OBJ),
                          resultadoConsultaLogs.getDate(DATE),
                          resultadoConsultaLogs.getTime(HOUR),
                          user.getName());

            logs.add(log);
        }

        ConnectionHandler.obtenerInstancia( ).desconectarConBD( );

        return logs;
    }
    
    public ArrayList<Log> getLogConcepts_Topics(String nameObj) throws ClassNotFoundException, SQLException{
        ConnectionHandler.obtenerInstancia( ).conectarConBD( );
        conexionBD = ConnectionHandler.obtenerConexion( );

        consultaBD = SELECT_STRING + "*" + FROM_STRING + "log where NAME_OBJ = \""+nameObj+"\"";
        sentenciaConsulta = conexionBD.createStatement( );
        ResultSet resultadoConsultaLogs = sentenciaConsulta.executeQuery( consultaBD );
        
        ArrayList<Log> logs= new ArrayList<>( );
        Log log;
        
        while ( resultadoConsultaLogs.next() ) {
            DAOUser daoUser = new DAOUser();
            User user = daoUser.getUser(resultadoConsultaLogs.getInt(ID_USER));
        
            log = new Log(resultadoConsultaLogs.getInt(CLAVE_LOG),
                          resultadoConsultaLogs.getString(MOV_TYPE),
                          resultadoConsultaLogs.getString(NAME_OBJ),
                          resultadoConsultaLogs.getDate(DATE),
                          resultadoConsultaLogs.getTime(HOUR),
                          user.getName());

            logs.add(log);
        }

        ConnectionHandler.obtenerInstancia( ).desconectarConBD( );

        return logs;
    }
    
    public ArrayList<Log> getLogUsers(int id) throws ClassNotFoundException, SQLException{
        ConnectionHandler.obtenerInstancia( ).conectarConBD( );
        conexionBD = ConnectionHandler.obtenerConexion( );

        consultaBD = SELECT_STRING + "*" + FROM_STRING + "log where ID_USER = \""+id+"\"";
        sentenciaConsulta = conexionBD.createStatement( );
        ResultSet resultadoConsultaLogs = sentenciaConsulta.executeQuery( consultaBD );
        
        ArrayList<Log> logs= new ArrayList<>( );
        Log log;
        
        while ( resultadoConsultaLogs.next() ) {
            DAOUser daoUser = new DAOUser();
            User user = daoUser.getUser(resultadoConsultaLogs.getInt(ID_USER));
        
            log = new Log(resultadoConsultaLogs.getInt(CLAVE_LOG),
                          resultadoConsultaLogs.getString(MOV_TYPE),
                          resultadoConsultaLogs.getString(NAME_OBJ),
                          resultadoConsultaLogs.getDate(DATE),
                          resultadoConsultaLogs.getTime(HOUR),
                          user.getName());

            logs.add(log);
        }

        ConnectionHandler.obtenerInstancia( ).desconectarConBD( );

        return logs;
    }
}
