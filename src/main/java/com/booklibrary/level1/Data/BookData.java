package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Book;
import com.booklibrary.level1.entity.Reader;


import java.util.ArrayList;

public class BookData {

   private static final ArrayList<Book> bookArray = new ArrayList<>();

    public static void generateBooks() {

        Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
        Book b3 = new Book(1, "Мастер и Маргарита", "Михаил Булгаков");
        bookArray.add(b1);
        bookArray.add(b2);
        bookArray.add(b3);

    }

    public static ArrayList<Book> getAllBooks() {
        System.out.println("Все книги: ");
        bookArray.forEach(bookArray-> System.out.println(bookArray));

        return bookArray;
    }

}
