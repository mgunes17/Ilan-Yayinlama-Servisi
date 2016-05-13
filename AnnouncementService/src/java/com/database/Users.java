package com.database;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public class Users implements Serializable {
    @Id
    @Column(name="user_name")
    private String userName;
    @Column(nullable = false)
    private String password;
    @Column(name="user_type_no")
    private int userTypeNo;

    public Users (){}
    
    public Users(String userName, String password, int userTypeNo){
        this.userName = userName;
        this.password = password;
        this.userTypeNo = userTypeNo;
    }
      
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getUserTypeNo() {
        return userTypeNo;
    }

    public void setUserTypeNo(int userTypeNo) {
        this.userTypeNo = userTypeNo;
    }
    
}
