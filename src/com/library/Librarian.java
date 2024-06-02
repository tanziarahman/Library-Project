package com.library;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Librarian {
    private static final int ID = 11786;
    private static final String password = "abcd";
    protected static List<Book> books = new ArrayList<>();
    protected static List<LibraryMember> members = new ArrayList<>();
    public static int getId(){
        return ID;
    }
    public static String getPassword(){
        return password;
    }
    protected static void defaultBooks(){
        try{
            Scanner sc = new Scanner(new File("Books.txt"));
            while(sc.hasNextLine()){
                String line = sc.nextLine();
                String[] parts = line.split(",");
                if(parts.length==3){
                    String title = parts[0].trim();
                    String author = parts[1].trim();
                    String q = parts[2].trim();
                    int quantity = Integer.parseInt(q);
                    books.add(new Book(title,author,quantity));
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void addBook(String title, String author, int quantity){
        books.add(new Book(title,author,quantity));
    }
    public static void removeBook(Book b){
        books.remove(b);
    }
    protected static void defaultLibraryMembers(){
        try{
            Scanner file = new Scanner(new File("Members.txt"));
            while(file.hasNextLine()){
                String line = file.nextLine();
                String[] parts = line.split(",");
                if(parts.length==2){
                    String ID = parts[0].trim();
                    String pass = parts[1].trim();
                    int id = Integer.parseInt(ID);
                    members.add(new LibraryMember(id,pass));
                }
            }
            file.close();
        }
        catch(FileNotFoundException e){
            e.printStackTrace();
        }
    }
    public static void checkCredentials (int id, String pass) throws WrongCredentialsException{
        if(id==ID && pass.equals(password)){
        }
        else{
            throw new WrongCredentialsException("Invalid ID / Password");
        }
    }
    public static void addMember(int ID, String pass){
        LibraryMember m = new LibraryMember(ID,pass);
        members.add(m);
    }
    public static void removeMember(LibraryMember m){
        members.remove(m);
    }
    public static void verifyMember(int ID,String password) throws WrongCredentialsException{
        for(LibraryMember m : members){
            if(ID==m.getID() && password.equals(m.getPassword())){
                return;
            }
        }
        throw new WrongCredentialsException("Invalid ID / Password");
    }
}
