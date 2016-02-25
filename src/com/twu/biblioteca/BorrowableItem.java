package com.twu.biblioteca;

public class BorrowableItem {
    String title;
    String creator;
    String noun;
    int yearReleased;
    int rating;
    Boolean checkedOut;

    public BorrowableItem(String title, String creator, int yearReleased, int rating){
        this.title = title;
        this.creator = creator ;
        this.yearReleased = yearReleased;
        this.rating = rating;
        checkedOut = false;
    }

    public Boolean checkOut(){
        Boolean success;

        success = !checkedOut;

        if(success){
            checkedOut = true;
        }

        return success;
    }

    public String getTitle(){
        return title;
    }

    public String getCreator() {
        return creator;
    }

    public int getYearReleased() {
        return yearReleased;
    }

    public int getRating() {
        return rating;
    }

    public Boolean getCheckedOut() {
        return checkedOut;
    }

    public Boolean returnBorrowableItem(){
        Boolean success;

        success = checkedOut;

        if(success){
            checkedOut = false;
        }

        return success;
    }
}
