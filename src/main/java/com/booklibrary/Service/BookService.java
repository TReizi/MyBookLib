package com.booklibrary.Service;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

public class BookService {

    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner booksEnter = new Scanner(System.in);
    private static final AtomicLong newId = new AtomicLong(1000);


    public static ArrayList <Book> getBookArrayList() {
        return bookList;
    }

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

    public static void addNewBook() {
        System.out.println("Укажите название книги и автора черех /. ");
        String newBook = booksEnter.nextLine();
        Book book = new Book();
        String[] separation = newBook.split("/");
        book.setName(separation[0]);
        book.setAuthor(separation[1]);
        book.setId(newId.incrementAndGet());
        bookList.add(book);

    }

}
