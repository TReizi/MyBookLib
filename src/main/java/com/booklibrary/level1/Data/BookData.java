package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Book;


import java.util.ArrayList;

public class BookData {

    private static final ArrayList<Book> bookList = new ArrayList<>();

    public static void generateBooks() {
        Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
        Book b3 = new Book(3, "Мастер и Маргарита", "Михаил Булгаков");
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

    }

    public static void printAllBooks(){
        System.out.println("Все книги: ");
        bookList.forEach(System.out::println);
    }
}
