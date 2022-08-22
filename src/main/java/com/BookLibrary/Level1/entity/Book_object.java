package com.BookLibrary.Level1.entity;

public class Book_object {
    private int id;

    private String name;

    private String author;

    public Book_object(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    //конструктор без аргументов добавлен для дальнейшего
    public Book_object() {
    }

    @Override
    public String toString() {
        return "Book_object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
