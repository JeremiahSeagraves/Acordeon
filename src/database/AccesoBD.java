/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.Statement;

class AccesoBD {
    
    protected static Connection conexionBD;
    protected String consultaBD;
    protected Statement sentenciaConsulta;
    
    protected static final String SELECT_STRING = "SELECT ";
    protected static final String FROM_STRING = " FROM ";
    protected static final String INSERT_STRING = "INSERT ";
    protected static final String INTO_STRING = " INTO ";
    protected static final String VALUES_STRING = " VALUES ";
    protected static final String DELETE_STRING = " DELETE ";
    protected static final String WHERE_STRING = " WHERE ";
    protected static final String UPDATE_STRING = " UPDATE ";
    protected static final String SET_STRING = " SET ";
    
}
