/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models.Sesion;
import java.io.Serializable;

/**
 *
 * @author juan
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;
    private int idUser;
    private String name;
    private String password;

    public User(int idUser, String name, String password) {
        this.idUser = idUser;
        this.name = name;
        this.password = password;
    }
    
     public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
