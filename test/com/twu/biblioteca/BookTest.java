package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

public class BookTest {

    public ArrayList<BorrowableItem> getBookList(){
        Book b1984 = new Book("1984","George Orwell",1949);
        Book bLolita = new Book("Lolita","Vladmir Nabokov",1955);
        Book bOldPat = new Book("The Old Patagonian Express","Paul Theroux",1979);

        ArrayList<BorrowableItem> bookList = new ArrayList<BorrowableItem>();

        bookList.add(b1984);
        bookList.add(bLolita);
        bookList.add(bOldPat);

        return bookList;
    }

    public ArrayList<BorrowableItem> checkout1984(ArrayList<BorrowableItem> bl){
        bl.get(0).checkOut();
        return bl;
    }

    @Test
    public void testBooksAvailableAtStart(){
        ArrayList<BorrowableItem> bl = getBookList();
        assertFalse(bl.get(0).checkedOut);
    }

    @Test
    public void testBookCheckout(){
        ArrayList<BorrowableItem> bl = getBookList();
        bl = checkout1984(bl);
        assertTrue(bl.get(0).checkedOut);
    }

    @Test
    public void testTitle(){
        ArrayList<BorrowableItem> bl = getBookList();
        assertEquals(bl.get(0).getTitle(), "1984");
    }

    @Test
    public void testBookCheckoutSuccess(){
        ArrayList<BorrowableItem> bl = getBookList();
        assertTrue(bl.get(0).checkOut());
    }

    @Test
    public void testBookCheckoutFailure(){
        ArrayList<BorrowableItem> bl = getBookList();
        bl = checkout1984(bl);
        assertFalse(bl.get(0).checkOut());
    }

    @Test
    public void testBookReturn(){
        ArrayList<BorrowableItem> bl = getBookList();
        bl = checkout1984(bl);
        bl.get(0).returnBorrowableItem();
        assertFalse(bl.get(0).checkedOut);
    }
}
