/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package log.models;

/**
 *
 * @author Milka
 */

public class Log{
    private int id;
    private String movType;
    private String objType;
    private String objName;
    private String date;
    private String hour;
    private String user;
   
    public Log(String movType, String objType, String objName, String date, String hour, String user) {
        this.movType = movType;
        this.objType = objType;
        this.objName = objName;
        this.date = date;
        this.hour = hour;
        this.user = user;
    }
    
    public Log(int id, String movType, String objType, String objName, String date, String hour, String user) {
        this.id = id;
        this.movType = movType;
        this.objType = objType;
        this.objName = objName;
        this.date = date;
        this.hour = hour;
        this.user = user;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMovType() {
        return movType;
    }

    public void setMovType(String movType) {
        this.movType = movType;
    }

    public String getObjType() {
        return objType;
    }

    public void setObjType(String objType) {
        this.objType = objType;
    }

    public String getObjName() {
        return objName;
    }

    public void setObjName(String objName) {
        this.objName = objName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
}
