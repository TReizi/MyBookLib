package com.booklibrary.level1.entity;

import java.util.concurrent.atomic.AtomicInteger;

public class Reader {
    private long id;



    private String name;

    public Reader(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //конструктор без аргументов добавлен для дальнейшего
    public Reader() {
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




}
