package com.twu.biblioteca;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Login {
    final private String usernameRegex = "^\\d{3}-\\d{4}$";
    final String LOGIN_SCREEN = "Login: ";
    final String PASSWORD_SCREEN = "Password: ";
    Map<String, User> userMap = new HashMap<String, User>();

    public Login(Map<String, User> userMap){
        this.userMap = userMap;
    }

    public Boolean validateUsernameFormat(String username){
        return username.matches(usernameRegex);
    }

    public Boolean usernameExists(String username){
        return userMap.get(username) != null;
    }

    public String validateUsernameMessage(String username){
        String msg = "";
        if(!validateUsernameFormat(username)){
            msg = "Incorrectly formatted username. Must be \"xxx-xxxx\".";
        } else if(!usernameExists(username)) {
            msg = "Username doesn't exist.";
        }
        return msg;
    }

    public String getUsernameFromUser() {
        Scanner input = new Scanner(System.in);
        String username = "";
        Boolean validUsername = false;

        while (!validUsername) {
            System.out.println(getLoginScreen());
            username = input.next();
            validUsername = validateUsernameFormat(username) && usernameExists(username);

            if (!validUsername) {
                System.out.println(validateUsernameMessage(username));
            }
        }

        return username;
    }

    private void getPasswordFromUser(User user){
        Scanner input = new Scanner(System.in);
        String password = "";
        Boolean validPassword = false;

        while(!validPassword){
            System.out.println(getPasswordScreen());
            password = input.next();

            validPassword = user.validatePassword(password);

            if(!validPassword){
                System.out.println("Invalid Password. Try again.");
            }
        }

    }

    public User runLoginScreen(){
        String username = getUsernameFromUser();
        User user = userMap.get(username);
        getPasswordFromUser(user);

        return user;
    }

    public String getLoginScreen(){
        return LOGIN_SCREEN;
    }

    public String getPasswordScreen(){
        return PASSWORD_SCREEN;
    }

}
