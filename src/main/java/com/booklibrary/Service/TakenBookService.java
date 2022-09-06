package com.booklibrary.Service;

import com.booklibrary.entity.TakenBook;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static com.booklibrary.Service.BookService.findBookById;
import static com.booklibrary.Service.ReaderService.*;


public class TakenBookService {
    private static ArrayList<TakenBook> takenReaderBookList = new ArrayList<>();
    private static AtomicLong idTakenBooks = new AtomicLong();
    private static final Scanner takenReaderBooksEnter = new Scanner(System.in);


    public static ArrayList<TakenBook> getTakenReaderBookList() {
        return takenReaderBookList;
    }


    public static void bookIssuance() {
        System.out.println("Укажите id читателя: ");
        long readersId = takenReaderBooksEnter.nextInt();
        TakenBook takenBook = new TakenBook();
        takenBook.setReader(findReaderById(readersId));
        System.out.println("Укажите id книги: ");
        long bookId = takenReaderBooksEnter.nextInt();
        takenBook.setNameBook(findBookById(bookId));
        takenReaderBookList.add(takenBook);
        System.out.println("Взял книгу: " + takenBook.getReader().getName() +
                ". По названию: " + takenBook.getNameBook().getName() + ".");
    }

    public static void removingBooksFromTheReader() {
        System.out.println("Укажите id читателя для возврата книги: ");
        long readerId = takenReaderBooksEnter.nextInt();
        System.out.println("Укажите id книги для возврата: ");
        long bookId = takenReaderBooksEnter.nextInt();
        Iterator<TakenBook> removingIterator = takenReaderBookList.iterator();
        while (removingIterator.hasNext()) {
            TakenBook nextTakenBook = removingIterator.next();
            if (nextTakenBook.getReader().getId() == readerId) {
                if (nextTakenBook.getNameBook().getId() == bookId) {
                    removingIterator.remove();
                }
            }
        }
        System.out.println("Книгу вернули.");
    }


    public static void takenReaderBook() {
        System.out.println("Укажите id читателя: ");
        int idSearchReaders = takenReaderBooksEnter.nextInt();
        List<TakenBook> searchReader = filterByReader(takenReaderBookList, idSearchReaders);
        System.out.println("Читатель : " + searchReader.get(0).getReader().getName());
        System.out.println("Взята книга: " + searchReader.get(0).getNameBook().getName());
    }

    public static void takenBookReader() {
        System.out.println("Укажите id книги: ");
        int idSearchBooks = takenReaderBooksEnter.nextInt();
        List<TakenBook> searchBook = filterByBook(takenReaderBookList, idSearchBooks);
        System.out.println("Книга: " + searchBook.get(0).getNameBook().getName());
        System.out.println("Взята: " + searchBook.get(0).getReader().getName());
    }

    public static List<TakenBook> filterByBook(ArrayList<TakenBook> takenReaderBookList, long needBookId) {
        return takenReaderBookList.stream()
                .filter(filterBook -> filterBook.getNameBook().getId() == needBookId)
                .collect(Collectors.toList());
    }

    public static List<TakenBook> filterByReader(ArrayList<TakenBook> takenReaderBookList, long needReaderId) {
        return takenReaderBookList.stream()
                .filter(filterReader -> filterReader.getReader().getId() == needReaderId)
                .collect(Collectors.toList());
    }

}

