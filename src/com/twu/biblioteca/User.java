package com.twu.biblioteca;

import java.util.ArrayList;

public class User {
    private String username;
    private String password;
    private String contactInformation;
    public ArrayList<BorrowableItem> checkedOutList = new ArrayList<BorrowableItem>();

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

    public void addCheckout(BorrowableItem b){
        checkedOutList.add(b);
    }

    public void removeCheckoutByTitle(String title){
        for(int i = 0; i < checkedOutList.size(); i++){
            if(checkedOutList.get(i).getTitle().equals(title)){
                checkedOutList.remove(i);
                break;
            }
        }
    }

    public ArrayList<BorrowableItem> getCheckedOutList() {
        return checkedOutList;
    }
}
