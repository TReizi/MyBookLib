package com.booklibrary.exceptionOutput;

public class ExceptionServiceMethods extends RuntimeException {
  public ExceptionServiceMethods(String message){
    super(message);
  }

  public ExceptionServiceMethods(Exception exception) {
    super(exception);
  }
}
