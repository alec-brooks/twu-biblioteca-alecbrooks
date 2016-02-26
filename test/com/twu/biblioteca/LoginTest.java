package com.twu.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class LoginTest {
    final private String validLogin = "123-4567";
    final private Login login = new Login(generateNewUserList());

    private ArrayList<User> generateNewUserList(){
        User uAlec = new User("123-4567");
        User uJoe = new User("111-1111");
        User uJim = new User("222-2222");

        ArrayList<User> ul = new ArrayList<User>();

        ul.add(uAlec);
        ul.add(uJoe);
        ul.add(uJim);

        return ul;
    }

    @Test
    public void testValidLoginUsername(){
        assertTrue(login.validateUsername(validLogin));
    }

    @Test
    public void testInvalidMalformedUsername(){
        String malformedLogin = "1234567";
        assertFalse(login.validateUsername(malformedLogin));
    }

    @Test
    public void testUsernameExists(){
        assertTrue(login.usernameExists(validLogin));
    }

    @Test
    public void testUsernameNotExists(){
        String nonExistantLogin = "765-4321";
        assertFalse(login.usernameExists(nonExistantLogin));
    }
}
