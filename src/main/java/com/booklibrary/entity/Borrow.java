package com.booklibrary.entity;

public class Borrow {

  private Reader reader;

  private Book book;

  public Borrow(Reader reader, Book book) {
    this.reader = reader;
    this.book = book;
  }

  public Borrow() {}

  public Reader getReader() {
    return reader;
  }

  public void setReader(Reader reader) {
    this.reader = reader;
  }

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  @Override
  public String toString() {
    return "Borrow{" + ", reader=" + reader + ", nameBooks=" + book + '}';
  }
}
