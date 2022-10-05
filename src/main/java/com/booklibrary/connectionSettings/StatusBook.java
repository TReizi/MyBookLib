package com.booklibrary.connectionSettings;

public enum StatusBook {
  available("Можно взять"),
  taken(" Взята ");

  private String statusBook;

  StatusBook(String statusBook) {
    this.statusBook = statusBook;
  }
  public String getStatusBook(){
    return statusBook;
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
