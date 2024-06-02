package com.library;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String msg){
        super(msg);
    }
}
