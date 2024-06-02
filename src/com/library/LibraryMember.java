package com.library;

import java.io.FileWriter;
import java.io.IOException;

public class LibraryMember {
    private int ID;
    private String password;

    public LibraryMember(int ID, String password){
        this.ID = ID;
        this.password = password;
    }
    protected int getID(){
        return ID;
    }
    public String getPassword(){
        return password;
    }
    public void addReview(Book b, String message){
        try{
            FileWriter file = new FileWriter("Reviews.txt",true);
            file.write(b.getTitle()+": "+message+"\n");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
   /* public static void borrowBook(int ID, String title, String startDate){
        if (Book.isAvailable(title)) {
            Book.addToBorrowList(ID, title, startDate);
            Book.lessenQuantityAfterBorrowing(title);
            System.out.println(title + " has been borrowed");
        } else if (Book.isAvailable(title)==false) {
            System.out.println("This book is currently not available");
        }
    }*/

    public static boolean returnBook(int ID, String title, String endDate){
        for(BookBorrowRecord b : Book.borrowed){
            if(b.getID()==ID && title.equals(b.getTitle())){
                return true;
            }
        }
        return false;
    }
    public static void recommend(int ID, String message){
        System.out.println("Do you want to recommend this book?");
        if(message=="Yes"){
            System.out.println("Your recommendation has been recorded");
        }
        else if(message=="No"){
            System.out.println("Okay");
        }
    }
}
