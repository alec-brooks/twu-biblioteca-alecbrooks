package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginTest {
    final private String validLogin = "123-4567";
    final private String malformedLogin = "1234567";
    final private String nonExistantLogin = "765-4321";
    final private Login login = new Login(generateNewUserMap());

    private Map<String, User> generateNewUserMap(){
        User uAlec = new User("123-4567", "abc");
        User uJoe = new User("111-1111", "123");
        User uJim = new User("222-2222", "you&me");

        Map<String, User> um = new HashMap<String, User>();

        um.put(uAlec.getUsername(), uAlec);
        um.put(uJoe.getUsername(), uJoe);
        um.put(uJim.getUsername(), uJim);

        return um;
    }

    @Test
    public void testLogInScreen(){
        String loginScreen = "Login: ";
        assertEquals(loginScreen, login.getLoginScreen());
    }

    @Test
    public void testPasswordScreen(){
        String passwordScreen = "Password: ";
        assertEquals(passwordScreen, login.getPasswordScreen());
    }

    @Test
    public void testValidLoginUsername(){
        assertTrue(login.validateUsernameFormat(validLogin));
    }

    @Test
    public void testInvalidMalformedUsername(){
        assertFalse(login.validateUsernameFormat(malformedLogin));
    }

    @Test
    public void testUsernameExists(){
        assertTrue(login.usernameExists(validLogin));
    }

    @Test
    public void testUsernameNotExists(){
        assertFalse(login.usernameExists(nonExistantLogin));
    }

    @Test
    public void testMalformedUsernameMessage(){
        assertEquals("Incorrectly formatted username. Must be \"xxx-xxxx\".", login.validateUsernameMessage(malformedLogin));
    }

    @Test
    public void testNonExistantUsernameMessage(){
        assertEquals("Username doesn't exist.", login.validateUsernameMessage(nonExistantLogin));
    }

}
