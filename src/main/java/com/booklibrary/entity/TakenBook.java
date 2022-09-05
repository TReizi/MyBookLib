package com.booklibrary.entity;

public class TakenBook {
    private long id;

    private Reader reader;

    private  Book nameBook;

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

    public Book getNameBook() {
        return nameBook;
    }

    public void setNameBook(Book nameBook) {
        this.nameBook = nameBook;
    }

    @Override
    public String toString() {
        return "TakenBook{" +
                "id=" + id +
                ", reader=" + reader +
                ", nameBooks=" + nameBook +
                '}';
    }
}
