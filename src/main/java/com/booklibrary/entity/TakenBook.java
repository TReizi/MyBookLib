package com.booklibrary.entity;


public class TakenBook {

    private Reader reader;

    private  Book book;

    public TakenBook(Reader reader, Book book) {
        this.reader = reader;
        this.book = book;
    }

    public Reader getReader() {
        return reader;
    }
    public TakenBook() {
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
                ", reader=" + reader +
                ", nameBooks=" + book +
                '}';
    }
}
