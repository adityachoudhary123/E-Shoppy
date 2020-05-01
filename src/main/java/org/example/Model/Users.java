package org.example.Model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
public class Users {
    @Id
    private String USER_ID;
    private  String NAME;
    private  String PASSWORD;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    @Override
    public String toString() {
        return "User{" +
                "USER_ID='" + USER_ID + '\'' +
                ", NAME='" + NAME + '\'' +
                ", PASSWORD='" + PASSWORD + '\'' +
                '}';
    }
}
