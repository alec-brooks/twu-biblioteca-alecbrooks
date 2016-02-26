package com.twu.biblioteca;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class UserTest {
    @Test
    public void testUserCreation(){
        assertEquals(new User("123-4567").getUsername(), "123-4567");
    }
}
