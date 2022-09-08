package com.booklibrary.service;

import com.booklibrary.entity.TakenBook;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TakenBookService {
    private final ArrayList<TakenBook> takenReaderBookList = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);
    private final BookService bookService ;
    private final ReaderService readerService;

    public TakenBookService(BookService bookService, ReaderService readerService){
        this.bookService = bookService;
        this.readerService= readerService;
    }

    public void issueBook() {
        System.out.println("Укажите id читателя: ");
        long readerId = scanner.nextInt();
        System.out.println("Укажите id книги: ");
        long bookId = scanner.nextInt();
        var reader = readerService.findReaderById(readerId);
        var book = bookService.findBookById(bookId);
        var takenBook = new TakenBook(reader, book);
        takenReaderBookList.add(takenBook);
        System.out.println("Взял книгу: " + reader.getName() + ". По названию: " + book.getName() + ".");
    }

    public void removeBookFromReader() {
        System.out.println("Укажите id читателя для возврата книги: ");
        long readerId = scanner.nextInt();
        System.out.println("Укажите id книги для возврата: ");
        long bookId = scanner.nextInt();
        takenReaderBookList.removeIf(x -> readerId == x.getReader().getId() && bookId == x.getBook().getId());
        System.out.println("Книгу вернули.");
    }

    public void printAllBooksTakenByReaderId() {
        System.out.println("Укажите id читателя: ");
        long idSearchReaders = scanner.nextInt();
        var takenBook = filterByReader(idSearchReaders).get(0);
        System.out.println("Читатель :" + takenBook.getReader().getName());
        System.out.println("Взята книга: " + takenBook.getBook().getName());
    }

    public void printCurrentReaderByBookId() {
        System.out.println("Укажите id книги: ");
        long bookId = scanner.nextInt();
        var takenBook = filterByBook(bookId).get(0);
        System.out.println("Книга: " + takenBook.getBook().getName());
        System.out.println("Взята :" + takenBook.getReader().getName());
    }

    public List<TakenBook> filterByBook(long bookId) {
       return takenReaderBookList.stream()
                .filter(filterBook -> filterBook.getBook().getId() == bookId)
                .collect(Collectors.toList());
    }

    public List<TakenBook> filterByReader(long readerId) {
        return takenReaderBookList.stream()
                .filter(filterReader -> filterReader.getReader().getId() == readerId)
                .collect(Collectors.toList());
    }
}

