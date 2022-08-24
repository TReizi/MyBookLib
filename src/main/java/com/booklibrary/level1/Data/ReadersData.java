package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Book;
import com.booklibrary.level1.entity.Reader;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

import static com.booklibrary.level1.Data.BookData.bookArray;
import static com.booklibrary.level1.Data.BookData.pickUpBooks;
import static java.util.Arrays.asList;


public class ReadersData {

    private static Scanner readersEnter = new Scanner(System.in);
    private static final AtomicLong newId = new AtomicLong(3);
    private static final ArrayList<Reader> readersArray = new ArrayList<>();


    public static void generateReaders() {

        Reader r1 = new Reader(1, "Artem");
        Reader r2 = new Reader(2, "Oleg");
        Reader r3 = new Reader(3, "Nina");
        readersArray.add(r1);
        readersArray.add(r2);
        readersArray.add(r3);

    }

    public static ArrayList<Reader> getAllReaders() {
        System.out.println("Все читатели: ");
        readersArray.forEach(readersArray -> System.out.println(readersArray));
        return readersArray;

    }

    public static ArrayList<Reader> addNewReaders() {
        System.out.println("Укажите имя нового читателя: ");
        String readersName = readersEnter.nextLine();
        Reader reader = new Reader();
        reader.setName(readersName);
        newId.incrementAndGet();
        long i =newId.get();
        reader.setId(i);
        readersArray.add(reader);
        return readersArray;
    }
//покачто не смотреть на это!
    public  static ArrayList<Reader> getBook(){

        System.out.println("Укажите ID читателя: ");
        int idReaders = readersEnter.nextInt();
        idReaders--;
        System.out.println("Укажите ID книги которую хотите взять : ");
        int idBooks = readersEnter.nextInt();
        idBooks--;

        StringBuilder sb1 = new StringBuilder((CharSequence) readersArray.get(idReaders));
        StringBuilder sb2 = new StringBuilder((CharSequence) bookArray.get(idBooks));
        StringBuilder [] array = {sb1,sb2};
        System.out.println("asdasda");
        System.out.println(array);
        System.out.println("asdasda");

        System.out.println(readersArray.get(idReaders) );//для проверки
        System.out.println(bookArray.get(idBooks) );//для проверки
        System.out.println();
        return readersArray;
    }




}
