/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topics.models;

import java.io.Serializable;

/**
 *
 * @author Milka
 */
public class Concept implements Serializable, Comparable<Concept>{
    private static final long serialVersionUID = 1L;    
    private int id;
    private String name;
    private String description;
    private int userId;
    private int topicId;

    public Concept(int id, String name, String description, int userId, int topicId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.topicId = topicId;
    }

    public Concept (String name, String description, int userId, int topicId){
        this.name = name;
        this.description = description;
        this.userId = userId;
        this.topicId = topicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getTopicId() {
        return topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Override
    public String toString() {
        return "Concept{" + "id=" + id + ", name=" + name + ", description=" + description + ", userId=" + userId + '}';
    }

    @Override
    public int compareTo(Concept o) {
        return getName().compareToIgnoreCase(o.getName());
    }

}
