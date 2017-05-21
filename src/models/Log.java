/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author Milka
 */

public class Log implements Serializable, Comparable<Log>{
    private int id;
    private String movType;
    private String objType;
    private Date date;
    private Time hour;
    private String user;
   
    public Log(String movType, String objType, Date date, Time hour, String user) {
        this.movType = movType;
        this.objType = objType;
        this.date = date;
        this.hour = hour;
        this.user = user;
    }
    
    public Log(int id, String movType, String objType, Date date, Time hour, String user) {
        this.id = id;
        this.movType = movType;
        this.objType = objType;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getHour() {
        return hour;
    }

    public void setHour(Time hour) {
        this.hour = hour;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
    
    public Date getDateTime(){
        Date date = this.date;
        date.setHours(this.hour.getHours());
        date.setMinutes(this.hour.getMinutes());
        date.setSeconds(this.hour.getSeconds());
        return date;
    }

    @Override
    public int compareTo(Log o) {
        return getDateTime().compareTo(o.getDateTime());
    }
    
}
