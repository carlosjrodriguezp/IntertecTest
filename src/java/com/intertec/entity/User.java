package com.intertec.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedQueries({@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u"),
                @NamedQuery(name = "User.getByName", query = "SELECT u FROM User u WHERE u.userName =:userName")
})
public class User implements Serializable {
    
    @Id
    @GeneratedValue
    @Column(name = "ID")
    private int userId;
    
    @Column(name = "NAME")
    private String userName;
    
    @Column(name = "ACTIVE")
    private Boolean userActive;
    
    public User(){
    
    }
    
    public User(String userName) {
        this.userName = userName;
    }

    public User(int userId, String userName, Boolean userActive) {
        this.userId = userId;
        this.userName = userName;
        this.userActive = userActive;
    }        

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Boolean getUserActive() {
        return userActive;
    }

    public void setUserActive(Boolean userActive) {
        this.userActive = userActive;
    }

}
