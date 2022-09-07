package com.booklibrary.entity;

import java.util.concurrent.atomic.AtomicLong;

public class TakenBook {
    private static AtomicLong atomicLong = new AtomicLong();

    private long id = atomicLong.incrementAndGet();

    private Reader reader;

    private  Book book;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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
        return "TakenBook{" +
                "id=" + id +
                ", reader=" + reader +
                ", nameBooks=" + book +
                '}';
    }
}
