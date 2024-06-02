package com.library;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class Book {
    private String title;
    private String author;
    private int quantity;
    protected static List<BookBorrowRecord> borrowed = new ArrayList<>();

    public Book(String title, String author, int quantity){
        this.title = title;
        this.author = author;
        this.quantity = quantity;
    }
    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }
    public String getTitle(){
        return title;
    }public int getQuantity(){
        return quantity;
    }
    public String getAuthor(){
        return author;
    }
    public static void lessenQuantityAfterBorrowing(String title){
        for(Book bk : Librarian.books){
            if(bk.getTitle()==title){
                bk.quantity = bk.quantity-1;
            }
        }
    }
    public static void isAvailable(String title) throws BookNotFoundException{
        for(Book bk : Librarian.books){
            if(title.equals(bk.getTitle()) && bk.getQuantity()>=1){
                return;
            }
        }
        throw new BookNotFoundException("Book titled "+title+ " is not currently available");
    }

    public static void searchBook(String title, String author) throws BookNotFoundException{
        for(Book bk : Librarian.books){
            if(title.equals(bk.getTitle()) && bk.getQuantity()>=1 && author.equals(bk.author)){
                return;
            }
        }
        throw new BookNotFoundException("Book titled "+title+" is not available.");
    }
    public static void addToBorrowList(int ID, String title, String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(date,formatter);
        Book.borrowed.add(new BookBorrowRecord(ID,title,date1));
    }
    public static int totalBorrowDays(int ID, String endDate,String title){
        LocalDate startDate = LocalDate.now();
        for(BookBorrowRecord bk : borrowed){
            if(bk.getID()==ID && title.equals(bk.getTitle())){
                startDate = bk.getStartDate();
            }
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date1 = LocalDate.parse(endDate,formatter);
        long daysBetween = ChronoUnit.DAYS.between(startDate, date1);
        return (int) daysBetween;
    }
    public static void removeFromBorrowList(int ID,String title){
        for(BookBorrowRecord bk: borrowed){
            if(bk.getTitle()==title && bk.getID()==ID){
                borrowed.remove(bk);
            }
        }
    }
    public static void addToStock(String title){
        for(Book bk : Librarian.books){
            if(bk.getTitle()==title){
                bk.quantity = bk.quantity+1;
            }
        }
    }

    public static int fine(int days){
        return 50*days;
    }
}
