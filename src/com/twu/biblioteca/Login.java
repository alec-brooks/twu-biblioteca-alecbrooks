package com.twu.biblioteca;

import java.util.ArrayList;

public class Login {
    final private String usernameRegex = "^\\d{3}-\\d{4}$";
    ArrayList<User> userList = new ArrayList<User>();

    public Login(ArrayList<User> userList){
        this.userList = userList;
    }

    public Boolean validateUsername(String username){
        return username.matches(usernameRegex);
    }

    public Boolean usernameExists(String username){
        Boolean success = false;
        for(User user: userList){
            if(user.getUsername().equals(username)){
                success = true;
            }
        }
        return success;
    }
}
