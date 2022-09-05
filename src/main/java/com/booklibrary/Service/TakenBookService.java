package com.booklibrary.Service;


import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;


public class TakenBookService {
    private static ArrayList<TakenBook> takenReaderBookList = new ArrayList<>();
    private static AtomicLong idTakenBooks = new AtomicLong();
    private static final Scanner takenReaderBooksEnter = new Scanner(System.in);


    public static ArrayList<TakenBook> getTakenReaderBookList() {
        return takenReaderBookList;
    }

    public static void setTakenReaderBookList(ArrayList<TakenBook> takenReaderBookList) {
        TakenBookService.takenReaderBookList = takenReaderBookList;
    }



    public static void generator(){

        TakenBook takenBook = new TakenBook();
        takenBook.setReader(new Reader(4,"Vasiliy"));
        takenBook.setNameBook(new Book(10,"A1","A1"));
        takenReaderBookList.add(takenBook);
        TakenBook takenBook1 = new TakenBook();
        takenBook1.setReader(new Reader(5,"A5"));
        takenBook1.setNameBook(new Book(11,"A11","A11"));
        takenReaderBookList.add(takenBook1);

    }

    public static void addBookReader() {




//        System.out.println("Укажите id читателя: ");
//        int readersId = takenReaderBooksEnter.nextInt();
//        readersId--;
//        TakenBook takenBooks = new TakenBook();
//        takenBooks.setReader(readersList.get(readersId));
//        System.out.println("Укажите id книги: ");
//        int booksId = takenReaderBooksEnter.nextInt();
//        booksId--;
//
//        System.out.println((bookList.get(booksId)));
//        takenBooks.setNameBook(bookList.get(booksId));
//        takenBooks.setId(idTakenBooks.incrementAndGet());
//        takenReaderBooksList.add(takenBooks);
//
//        System.out.println("Взял книгу: " + takenBooks.getReader().getName() +
//                ". По названию: " + takenBooks.getNameBook().getName() + ".");

    }


//    public static ArrayList<TakenBook> removingBooksFromTheReader() {
////        System.out.println("Укажите id читателя для возврата книги: ");
////        int readersId = takenReaderBooksEnter.nextInt();
////        readersId--;
////        long idReader = readersList.get(readersId).getId();
////        for (TakenBook idSearchReader : takenReaderBooksList)
////            if (idSearchReader.getReader().getId() == idReader) {
////                takenReaderBooksList.remove(idSearchReader.getReader().getId()) ;
////                        System.out.println("Книгу вернули.");
////            }
////        return takenReaderBooksList;
//    }


    public static void getReaderBooks() {
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
                .filter((filterBook)->filterBook.getReader().getId() == needReaderId)
                .collect(Collectors.toList());
    }
}

