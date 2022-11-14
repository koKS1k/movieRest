package com.example.movierest.exceptionHandlers;

public class MyException extends RuntimeException {

    public MyException( String reason) {
        super(reason);
    }
}