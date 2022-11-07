package com.booklibrary.entity;

public class Book {

  private long id;

  private String name;

  private String author;



  public Book(int id, String name, String author) {
    this.id = id;
    this.name = name;
    this.author = author;

  }

  public Book(long id) {
    this.id = id;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Book(String[] separation) {

    this.name = separation[0];
    this.author = separation[1];
    this.id = getId();
  }

  public Book() {}

  @Override
  public String toString() {
    return "Book{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", author='" + author + '\'' +
            '}';
  }
}
