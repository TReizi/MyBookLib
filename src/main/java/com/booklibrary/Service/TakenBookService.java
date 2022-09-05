package com.booklibrary.Service;


import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

import static com.booklibrary.Service.BookService.getBookArrayList;
import static com.booklibrary.Service.ReaderService.getReadersArrayList;


public class TakenBookService {
    private static ArrayList<TakenBook> takenReaderBookList = new ArrayList<>();
    private static AtomicLong idTakenBooks = new AtomicLong();
    private static final Scanner takenReaderBooksEnter = new Scanner(System.in);


    public static ArrayList<TakenBook> getTakenReaderBookList() {
        return takenReaderBookList;
    }

    public static void addBookReader() {
        System.out.println("Укажите id читателя: ");
        int readersId = takenReaderBooksEnter.nextInt();
        TakenBook takenBook = new TakenBook();
        // Не делал специально лямдой
        for(Reader reader:SearchReader(getReadersArrayList(),readersId)){
            takenBook.setReader(reader);
        }
        System.out.println("Укажите id книги: ");
        int bookId = takenReaderBooksEnter.nextInt();
        // Не делал специально лямдой
        for (Book book:SearchBook(getBookArrayList(),bookId)){
            takenBook.setNameBook(book);
        }
       takenReaderBookList.add(takenBook);
        System.out.println("Взял книгу: " + takenBook.getReader().getName() +
                ". По названию: " + takenBook.getNameBook().getName() + ".");
    }

    public static void removingBooksFromTheReader() {
        System.out.println("Укажите id читателя для возврата книги: ");
        int readerId = takenReaderBooksEnter.nextInt();
        for(TakenBook s: filterByReader(getTakenReaderBookList(),readerId)){
            takenReaderBookList.remove(s);
        }
        System.out.println("Книга возвращена.");
    }

    public static void getReaderBook() {
        System.out.println("Укажите id читателя: ");
        int idSearchReaders = takenReaderBooksEnter.nextInt();
        List<TakenBook> searchReader = filterByReader(getTakenReaderBookList(), idSearchReaders);
        System.out.println("Читатель : "+searchReader.get(0).getReader().getName());
        System.out.println("Взята книга: "+searchReader.get(0).getNameBook().getName());
    }

    public static void getBookReader() {
        System.out.println("Укажите id книги: ");
        int idSearchBooks = takenReaderBooksEnter.nextInt();
        List<TakenBook> searchBook = filterByBook(getTakenReaderBookList(), idSearchBooks);
        System.out.println("Книга: "+searchBook.get(0).getNameBook().getName());
        System.out.println("Взята: "+searchBook.get(0).getReader().getName());
    }

    public static List<TakenBook> filterByBook(ArrayList<TakenBook> takenReaderBookList, long needBookId) {
        return takenReaderBookList.stream()
                .filter((filterBook)->filterBook.getNameBook().getId() == needBookId)
                .collect(Collectors.toList());
    }

    public static List<TakenBook> filterByReader (ArrayList<TakenBook> takenReaderBookList, long needReaderId) {
        return takenReaderBookList.stream()
                .filter((filterReader)->filterReader.getReader().getId() == needReaderId)
                .collect(Collectors.toList());
    }

    public static List<Reader> SearchReader (ArrayList<Reader> idSearchReader , long needReaderId) {
        return getReadersArrayList().stream()
                .filter((searchReader)->searchReader.getId() == needReaderId)
                .collect(Collectors.toList());
    }

    public static List<Book> SearchBook (ArrayList<Book> idSearchBook , long needBook) {
        return getBookArrayList().stream()
                .filter((searchReader)->searchReader.getId() == needBook)
                .collect(Collectors.toList());
    }

}

