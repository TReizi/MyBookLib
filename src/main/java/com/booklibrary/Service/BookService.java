package com.booklibrary.Service;

import com.booklibrary.entity.Book;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class BookService {

    private static final ArrayList<Book> bookList = new ArrayList<>();
    private  static Scanner scanner = new Scanner(System.in);

    public static void generateBooks() {
        Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
        Book b3 = new Book(3, "Мастер и Маргарита", "Михаил Булгаков");
        bookList.add(b1);
        bookList.add(b2);
        bookList.add(b3);

    }

    public void printAllBooks(){
        System.out.println("Все книги: ");
        bookList.forEach(System.out::println);
    }

    public void addNewBook() {
        System.out.println("Укажите название книги и автора черех /. ");
        String newBook = scanner.nextLine();
        String[] separation = newBook.split("/");
        var book = new Book(separation);
        bookList.add(book);

    }

    public Book findBookById(Long bookId){
        return bookList.stream()
                .filter(book-> book.getId() == bookId)
                .findAny()
                .orElse(null);
    }

}
