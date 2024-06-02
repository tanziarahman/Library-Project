package com.library;

public class ExceptionSample {
    public static void main(String[] args) throws WrongCredentialsException{
       int n=0;
       if(n==0){
           throw new WrongCredentialsException("Wrong");
       }
    }
}
