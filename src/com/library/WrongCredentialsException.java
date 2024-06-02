package com.library;

public class WrongCredentialsException extends Exception{
    public WrongCredentialsException(String msg){
        super(msg);
    }
}
