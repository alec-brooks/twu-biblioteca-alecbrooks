package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class UserTest {
    User user = new User("123-4567", "abc");
    @Test
    public void testUserCreation(){
        assertEquals(user.getUsername(), "123-4567");
    }

    @Test
    public void testValidatePassword(){
        assertTrue(user.validatePassword("abc"));
    }
}
