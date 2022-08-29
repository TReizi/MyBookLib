package com.booklibrary.level2.Data;

import com.booklibrary.level2.entity.Book;
import com.booklibrary.level2.entity.TakenBooks;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;

import static com.booklibrary.level2.Data.BookData.bookList;
import static com.booklibrary.level2.Data.ReadersData.*;

public class TakenBooksData {
    private static final ArrayList<TakenBooks> takenReaderBooksList = new ArrayList<>();
    private static AtomicLong idTakenBooks = new AtomicLong();
    private static final Scanner takenReaderBooksEnter = new Scanner(System.in);


    public static void generateTakenReaderBooks() {
        TakenBooks takenBooks = new TakenBooks();
    }

    public static ArrayList<TakenBooks> addBooksReader() {
        System.out.println("Укажите id читателя: ");
        int readersId = takenReaderBooksEnter.nextInt();
        readersId--;
        TakenBooks takenBooks = new TakenBooks();
        takenBooks.setReader(readersList.get(readersId));
        System.out.println("Укажите id книги: ");
        int booksId = takenReaderBooksEnter.nextInt();
        booksId--;

        System.out.println((bookList.get(booksId)));
        takenBooks.setNameBooks(bookList.get(booksId));
        takenBooks.setId(idTakenBooks.incrementAndGet());
        takenReaderBooksList.add(takenBooks);

        System.out.println("Взял книгу: " + takenBooks.getReader().getName() +
                ". По названию: " + takenBooks.getNameBooks().getName() + ".");
        return takenReaderBooksList;
    }


    public static ArrayList<TakenBooks> removingBooksFromTheReader() {
        System.out.println("Укажите id читателя: ");
        int readersId = takenReaderBooksEnter.nextInt();
        readersId--;
        long idReader = readersList.get(readersId).getId();
        System.out.println("Укажите id книги которую необходимо вернуть: ");
        int bookId = takenReaderBooksEnter.nextInt();
        bookId--;

        for(TakenBooks idSearchReader:takenReaderBooksList)
        if (idSearchReader.getReader().getId() == idReader) {
                takenReaderBooksList.remove(idSearchReader);
                System.out.println("Книгу вернули.");
            }else{
            System.out.println("Такого читателя или книги не найдено");
        }

        return takenReaderBooksList;
    }


    public static ArrayList<TakenBooks> getReaderBooks() {
        System.out.println("Укажите id читателя: ");
        int idSearchReaders = takenReaderBooksEnter.nextInt();
        idSearchReaders--;
        long reader = readersList.get(idSearchReaders).getId();
        int idSearchBooks = 0;
        for (TakenBooks idSearchBook : takenReaderBooksList) {
            if (idSearchBook.getReader().getId() == reader){

              }
            System.out.println(" У читателя: " + readersList.get(idSearchReaders).getName());
            System.out.println(" Взята книга: " + bookList.get(idSearchBooks).getName());
        }

        return takenReaderBooksList;
    }
}
