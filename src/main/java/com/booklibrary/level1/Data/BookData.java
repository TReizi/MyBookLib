package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Book;
import com.booklibrary.level1.entity.Reader;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class BookData {

    private static final ArrayList<Book> bookArray = new ArrayList<>();


    private static Scanner booksEnter = new Scanner(System.in);
    private static final AtomicLong newId = new AtomicLong(3);

    public static void generateBooks() {

        Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
        Book b3 = new Book(3, "Мастер и Маргарита", "Михаил Булгаков");
        bookArray.add(b1);
        bookArray.add(b2);
        bookArray.add(b3);

    }

    public static ArrayList<Book> getAllBooks() {
        System.out.println("Все книги: ");
        bookArray.forEach(bookArray -> System.out.println(bookArray));
        return bookArray;
    }


    public static ArrayList<Book> addNewBook() {
        System.out.println("Укажите название книги и автора черех /. ");
        String newBook = booksEnter.nextLine();
        Book books = new Book();
        String[] separation = newBook.split("/");
        books.setName(separation[0]);
        books.setAuthor(separation[1]);
        newId.incrementAndGet();
        long i = newId.get();
        books.setId(i);
        bookArray.add(books);

        return bookArray;
    }

}
