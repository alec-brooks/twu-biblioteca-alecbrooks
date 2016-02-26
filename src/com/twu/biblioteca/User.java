package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private String contactInformation;

    public User(String username, String password, String contactInformation){
        this.username = username;
        this.password = password;
        this.contactInformation = contactInformation;
    }

    public String getUsername(){
        return username;
    }

    public Boolean validatePassword(String passwordAttempt){
        return passwordAttempt.equals(password);
    }

    public String getContactInformation() {
        return contactInformation;
    }
}
