package com.booklibrary.dataValidation;

import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class DataValidation {

  public static boolean stringDataValidation(String stringDataValidation) {
    if (Pattern.compile("[0-9]").matcher(stringDataValidation).find()) {
      System.err.println("В этой строке нельзя использовать числа. " +stringDataValidation);
      return true;
    }
      return false;
  }
  public  static boolean validationNullString(String validationNullString){
    if(validationNullString.isEmpty()){
      System.out.println("Пусто");
      return false;
    }
    return false;
  }


}
