package com.booklibrary.level2.entity;

public class TakenBooks {
    private long id;

    private Reader reader;
    private  Book nameBooks;



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

    public Book getNameBooks() {
        return nameBooks;
    }

    public void setNameBooks(Book nameBooks) {
        this.nameBooks = nameBooks;
    }

    @Override
    public String toString() {
        return "TakenBooks{" +
                "id=" + id +
                ", reader=" + reader +
                ", nameBooks=" + nameBooks +
                '}';
    }
}
