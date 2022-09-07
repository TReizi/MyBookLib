package com.booklibrary.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Reader {
    private static final AtomicLong atomicLong = new AtomicLong(1000);
    private long id = atomicLong.incrementAndGet();

    private String name;

    public Reader(long id, String name) {
        this.id = id;
        this.name = name;
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


    //конструктор без аргументов добавлен для дальнейшего
    public Reader() {
    }

    public Reader (String name){
        this.name = name;
    }

    @Override
    public String toString() {
        return "Reader{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }




}
