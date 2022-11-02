package com.booklibrary.exceptionOutput;

public class ExceptionDAOMetods extends RuntimeException{
    public ExceptionDAOMetods(String message){
        super(message);
    }
    public ExceptionDAOMetods(Exception exception){
        super(exception);
    }

}
