package com.example.dashboardapplication.model;

import com.google.firebase.database.IgnoreExtraProperties;

import java.io.Serializable;
@IgnoreExtraProperties
public class User implements Serializable {
    private String name;
    private String password;
    private String Repassword;

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRepassword() {
        return Repassword;
    }

    public void setRepassword(String repassword) {
        Repassword = repassword;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String  toString(){
        return " " + name + "\n" +
                " " + password;
    }

    public User(String pss, String nm){
        name = nm;
        password = pss;
    }
}
