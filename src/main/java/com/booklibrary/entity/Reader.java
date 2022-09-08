package com.booklibrary.entity;

import java.util.concurrent.atomic.AtomicLong;

public class Reader {
    private static final AtomicLong atomicLong = new AtomicLong(1000);

    private final long id;

    private String name;

    public Reader(long id, String name) {
        this.id = id;
        this.name = name;
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

    public Reader (String name){
        this.id = atomicLong.incrementAndGet();
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
