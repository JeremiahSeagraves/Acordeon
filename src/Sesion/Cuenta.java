/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sesion;

/**
 *
 * @author juan
 */
public class Cuenta {
    private int userId;
    private String userName;
    private static Cuenta cuentaIniciada = null;
    
    private Cuenta() {
    }
    
    public static Cuenta obtenerCuentaIniciada(){
        if(cuentaIniciada == null){
            cuentaIniciada = new Cuenta();
        }
        return cuentaIniciada;
    }
    
    public static void establecerCuentaIniciada(int userId, String userName){
        cuentaIniciada.setUserId(userId);
        cuentaIniciada.setUserName(userName);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    
}
