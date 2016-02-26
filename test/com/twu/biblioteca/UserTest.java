package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class UserTest {
    User user = new User("123-4567", "abc", "a@b.com\n0411111111");
    @Test
    public void testUserCreation(){
        assertEquals(user.getUsername(), "123-4567");
    }

    @Test
    public void testValidatePassword(){
        assertTrue(user.validatePassword("abc"));
    }

    @Test
    public void testInvalidPassword(){
        assertFalse(user.validatePassword("cba"));
    }

    @Test
    public void testGetContactInformation(){
        assertEquals(user.getContactInformation(), "a@b.com\n0411111111");
    }
}
