/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import topics.models.Concept;

/**
 *
 * @author juan
 */

public class DAOConcept extends AccesoBD {
    
    private static final String CLAVE_STRING = "ID_CONCEPT";
    private static final String NOMBRE_STRING = "NAME";
    private static final String DESCRIPCION_STRING = "DESCRIPTION";
    private static final String ID_USER_STRING = "ID_USER";
    private static final String ID_TOPIC_STRING = "ID_TOPIC";
    
    public ArrayList<Concept> getConcepts( ) throws ClassNotFoundException, SQLException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
 
         consultaBD =  SELECT_STRING + "*" + FROM_STRING + "concepts";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaConcepts = sentenciaConsulta.executeQuery( consultaBD );
         
         ArrayList<Concept> concepts= new ArrayList<>( );
         Concept concept;
        
         while ( resultadoConsultaConcepts.next() ) {
            concept = new Concept(  Integer.parseInt(resultadoConsultaConcepts.getString( CLAVE_STRING )),
                                    resultadoConsultaConcepts.getString( NOMBRE_STRING ),
                                    resultadoConsultaConcepts.getString( DESCRIPCION_STRING ),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_USER_STRING )),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_TOPIC_STRING )));
            
            concepts.add(concept);
        }
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
        
         return concepts;
    }
    
    public ArrayList<Concept> getConceptsofATopic( int idTopic ) throws ClassNotFoundException, SQLException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
 
         consultaBD =  SELECT_STRING + "*" + FROM_STRING + "concepts where ID_TOPIC = \""+idTopic+"\"" ;
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaConcepts = sentenciaConsulta.executeQuery( consultaBD );
         
         ArrayList<Concept> concepts= new ArrayList<>( );
         Concept concept=null;
        try{
         while ( resultadoConsultaConcepts.next() ) {
            concept = new Concept(  Integer.parseInt(resultadoConsultaConcepts.getString( CLAVE_STRING )),
                                    resultadoConsultaConcepts.getString( NOMBRE_STRING ),
                                    resultadoConsultaConcepts.getString( DESCRIPCION_STRING ),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_USER_STRING )),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_TOPIC_STRING )));
            
            concepts.add(concept);
        }
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
        
         return concepts;
        }catch(SQLException ex){
            
        }
        return null;
    }
   
   
   public void insertarConcepto( Concept concepto ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = INSERT_STRING + INTO_STRING + "concepts" + VALUES_STRING
                        +"("        + "null"                       + ", "
                        + "\""      + concepto.getName()         + "\", "
                        + "\""      + concepto.getDescription()  + "\", "
                        + "\""      + concepto.getUserId()       + "\", "
                        + "\""      + concepto.getTopicId()      + "\")";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
         
    }
   
    public void eliminarConcepto( int claveConcepto ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = DELETE_STRING + FROM_STRING + "concepts" + WHERE_STRING + CLAVE_STRING + " = \"" + claveConcepto + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
    }
   
    
    public Concept buscarConcepto( String claveConcept ) throws SQLException, ClassNotFoundException {
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = SELECT_STRING + "*" + FROM_STRING + "concepts" + WHERE_STRING + CLAVE_STRING + "= \"" + claveConcept + "\"";
         sentenciaConsulta = conexionBD.createStatement( );
         ResultSet resultadoConsultaConcepts = sentenciaConsulta.executeQuery( consultaBD );
         
         //Omite el primero elemento del ResultSet el cual es una dirección de memoria
         resultadoConsultaConcepts.next( );
         
         Concept concept = new Concept(  Integer.parseInt(resultadoConsultaConcepts.getString( CLAVE_STRING )),
                                    resultadoConsultaConcepts.getString( NOMBRE_STRING ),
                                    resultadoConsultaConcepts.getString( DESCRIPCION_STRING ),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_USER_STRING )),
                                    Integer.parseInt(resultadoConsultaConcepts.getString( ID_TOPIC_STRING )));;
        
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
        
         return concept;
    }
    
    
    public void actualizarConcepto( Concept conceptoModificado ) throws SQLException, ClassNotFoundException{
         ConnectionHandler.obtenerInstancia( ).conectarConBD( );
         conexionBD = ConnectionHandler.obtenerConexion( );
        
         consultaBD = UPDATE_STRING + " concepts " + SET_STRING + " " 
                 + DESCRIPCION_STRING + " = \"" + conceptoModificado.getDescription( ) + "\" "
                 + WHERE_STRING + " " + CLAVE_STRING + " = \"" + conceptoModificado.getId()+ "\"";
         
         sentenciaConsulta = conexionBD.createStatement( );
         sentenciaConsulta.executeUpdate( consultaBD );
         
         ConnectionHandler.obtenerInstancia( ).desconectarConBD( );
       
    }
    

}