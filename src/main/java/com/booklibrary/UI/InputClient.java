package com.booklibrary.UI;

import java.util.Scanner;
import java.util.regex.Pattern;

public class InputClient {
  Scanner scanner = new Scanner(System.in);

  public String[] inputClientAddBook() {
    String separatorBook = scanner.nextLine();
    if (separatorBook.contains("/")) {
      String[] separation = separatorBook.split("/");
      return separation;
    }
    userErrorOutput();
    return inputClientAddBook();
  }
  // Добавяляет всех, проверка не работает
  public String inputClientAddNewReader() {
    String readerName = scanner.nextLine();
    if (Pattern.compile("[0-9]").matcher(readerName).find()) {
      userErrorOutput();
      return inputClientAddNewReader();
    }
    return readerName;
  }

  public long inputBookId() {
    System.out.println("Укажите id книги: ");
    long bookId = scanner.nextInt();
    return bookId;
  }

  public long inputReaderId() {
    System.out.println("Укажите id читателя: ");
    long readerID = scanner.nextInt();
    return readerID;
  }

  private void userErrorOutput() {
    System.out.println("Проверьте правильность введённых данных.\nПовторите ввод:");
  }
}
