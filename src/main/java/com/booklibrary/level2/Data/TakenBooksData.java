package com.booklibrary.level2.Data;

import com.booklibrary.level2.entity.TakenBooks;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import static com.booklibrary.level2.Data.BookData.bookList;
import static com.booklibrary.level2.Data.ReadersData.*;

public class TakenBooksData {
    private static final ArrayList<TakenBooks> takenReaderBooksList = new ArrayList<>();
    private static final AtomicLong idTakenBooks = new AtomicLong(1);
    private static final Scanner takenReaderBooksEnter = new Scanner(System.in);


    public static void generateTakenReaderBooks() {
        TakenBooks takenBooks = new TakenBooks();
    }


    public static ArrayList<TakenBooks> addBooksReader() {
        System.out.println("Укажите id читателя: ");
        int readersId = takenReaderBooksEnter.nextInt();
        TakenBooks takenBooks = new TakenBooks();
        readersId--;

        takenBooks.setReader(readersList.get(readersId));


        System.out.println("Укажите id книги: ");
        int booksId = takenReaderBooksEnter.nextInt();
        booksId--;
        takenBooks.setNameBooks(bookList.get(booksId));

        long idTakenBook = idTakenBooks.get();
        takenBooks.setId(idTakenBook);
        takenReaderBooksList.add(takenBooks);

        System.out.println("Взял книгу: " + takenBooks.getReader().getName() +
                ". По названию: " + takenBooks.getNameBooks().getName() + ".");
        return takenReaderBooksList;
    }


    public static ArrayList<TakenBooks> removingBooksFromTheReader() {


        return takenReaderBooksList;
    }


    public static ArrayList<TakenBooks> getReaderBooks() {
        System.out.println("Укажите id читателя: ");
        int idSearchReaders = takenReaderBooksEnter.nextInt();
        idSearchReaders--;
              long reader = readersList.get(idSearchReaders).getId();
        int idSearchBooks = 0;
        for (TakenBooks idSearchBook : takenReaderBooksList) {
            if (idSearchBook.getReader().getId() == reader) {
                idSearchBook.equals(idSearchBooks);
            }
        }


        System.out.println(" У читателя: " + readersList.get(idSearchReaders).getName());

        System.out.println(" Взята книга: " + takenReaderBooksList.get(idSearchBooks).getNameBooks().getName());


        return takenReaderBooksList;
    }
}
