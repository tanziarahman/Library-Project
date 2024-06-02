package com.library;


import java.time.LocalDate;

public class BookBorrowRecord {
    private String title;
    private LocalDate startDate;
    int ID;
    public BookBorrowRecord(int ID , String title, LocalDate startDate){
        this.title = title;
        this.startDate = startDate;
        this.ID=ID;
    }
    public LocalDate getStartDate(){
        return startDate;
    }
    public int getID(){
        return ID;
    }
    public String getTitle(){
        return title;
    }
}
