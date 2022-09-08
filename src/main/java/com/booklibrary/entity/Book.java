package com.booklibrary.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Book {
    private static AtomicLong atomicLong = new AtomicLong(1000);

    private final long id;

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


    public Book (String [] separation){
        this.id = atomicLong.incrementAndGet();
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
