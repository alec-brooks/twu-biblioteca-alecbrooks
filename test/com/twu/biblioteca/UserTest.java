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

    @Test
    public void testAddToCheckoutList(){
        Book b1984 = new Book("1984", "George Orwell", 1949);
        user.addCheckout(b1984);
        assertEquals(b1984.getTitle(), user.getCheckedOutList().get(0).getTitle());
    }

    @Test
    public void testReturnFromCheckoutListByTitle(){
        Book b1984 = new Book("1984", "George Orwell", 1949);
        user.addCheckout(b1984);
        user.removeCheckoutByTitle("1984");
        assertEquals(0, user.getCheckedOutList().size());
    }
}
