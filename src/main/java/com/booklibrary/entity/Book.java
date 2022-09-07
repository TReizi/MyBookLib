package com.booklibrary.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Book {
    private static AtomicLong atomicLong = new AtomicLong(1000);

    private long id = atomicLong.incrementAndGet();

    private String name;

    private String author;

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
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

    //конструктор без аргументов добавлен для дальнейшего
    public Book() {
    }

    public Book (String [] separation){
        this.name = separation[0];
        this.author = separation[1];
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                '}';
    }

}
