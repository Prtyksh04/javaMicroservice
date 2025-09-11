package com.ncu.college.users.model;

public class User {
    String userId;
    String name;
    String password;

    public User() {

    }

    public User(String userId, String name, String password) {
        this.userId = userId;
        this.name = name;
        this.password = password;

    }
    
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
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
