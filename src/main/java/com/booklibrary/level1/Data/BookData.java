package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Book;
import com.booklibrary.level1.entity.Reader;


import java.util.ArrayList;

public class BookData {


    public static ArrayList<Book> arrayListBooks() {
        ArrayList<Book> bookArray = new ArrayList<>();
        Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
        Book b3 = new Book(1, "Мастер и Маргарита", "Михаил Булгаков");
        bookArray.add(b1);
        bookArray.add(b2);
        bookArray.add(b3);
        return bookArray;
    }

    public static ArrayList<Book> getAllBooks(ArrayList<Book> bookArray) {
        System.out.println("Все книги: ");
        for (Book b : bookArray) {
            System.out.println(b);
        }

        return bookArray;
    }

}
