package com.BookLibrary.Level1.entity;

public class Reader_object {
    private int id;

    private String name;

    public Reader_object(int id, String name) {
        this.id = id;
        this.name = name;
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


    //конструктор без аргументов добавлен для дальнейшего
    public Reader_object() {
    }

    @Override
    public String toString() {
        return "Reader_object{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
