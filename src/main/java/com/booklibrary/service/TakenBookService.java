package com.booklibrary.service;

import com.booklibrary.entity.TakenBook;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;


public class TakenBookService {
    private final ArrayList<TakenBook> takenReaderBookList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);
    BookService bookService = new BookService();
    ReaderService readerService = new ReaderService();


    public void issueBook() {
        System.out.println("Укажите id читателя: ");
        long readerId = scanner.nextInt();
        TakenBook takenBook = new TakenBook();
        takenBook.setReader(readerService.findReaderById(readerId));
        System.out.println("Укажите id книги: ");
        long bookId = scanner.nextInt();
        takenBook.setBook(bookService.findBookById(bookId));
        takenReaderBookList.add(takenBook);
        System.out.println("Взял книгу: " + takenBook.getReader().getName() +
                ". По названию: " + takenBook.getBook().getName() + ".");
    }

    public void removeBookFromReader() {
        System.out.println("Укажите id читателя для возврата книги: ");
        long readerId = scanner.nextInt();
        System.out.println("Укажите id книги для возврата: ");
        long bookId = scanner.nextInt();
        takenReaderBookList.removeIf(x -> readerId == x.getReader().getId() && bookId == x.getBook().getId());
        System.out.println("Книгу вернули.");
    }

    public void printCurrentReaderByBookId() {
        System.out.println("Укажите id читателя: ");
        int idSearchReaders = scanner.nextInt();
        System.out.println("Читатель :"+filterByReader(idSearchReaders).get(0).getReader().getName());
        System.out.println("Взята книга: " + filterByReader(idSearchReaders).get(0).getBook().getName());
    }

    public void printAllBooksTakenByReaderId() {
        System.out.println("Укажите id книги: ");
        int idSearchBooks = scanner.nextInt();
        filterByBook(idSearchBooks);
        System.out.println("Книга: " + filterByBook(idSearchBooks).get(0).getBook().getName());
        System.out.println("Взята: " + filterByBook(idSearchBooks).get(0).getReader().getName());
    }

    public List<TakenBook> filterByBook(long bookId) {
        return takenReaderBookList.stream()
                .filter(filterBook -> filterBook.getBook().getId() == bookId)
                .collect(Collectors.toList());
    }

    public List<TakenBook> filterByReader( long readerId) {
        return takenReaderBookList.stream()
                .filter(filterReader -> filterReader.getReader().getId() == readerId)
                .collect(Collectors.toList());
    }

}
