package com.booklibrary.level2.Data;

import com.booklibrary.level2.entity.Reader;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

public class ReadersData {

    public static final ArrayList<Reader> readersList = new ArrayList<>();
    private static Scanner readersEnter = new Scanner(System.in);
    private static final AtomicLong newId = new AtomicLong(3);

    public static void generateReaders() {
        Reader r1 = new Reader(1, "Artem");
        Reader r2 = new Reader(2, "Oleg");
        Reader r3 = new Reader(3, "Nina");
        readersList.add(r1);
        readersList.add(r2);
        readersList.add(r3);

    }

    public static void printAllReaders(){
        System.out.println("Все книги: ");
        readersList.forEach(System.out::println);
    }
    public static ArrayList<Reader> addNewReaders() {
        System.out.println("Укажите имя нового читателя: ");
        String readersName = readersEnter.nextLine();
        Reader reader = new Reader();
        reader.setName(readersName);
        reader.setId(newId.incrementAndGet());
        readersList.add(reader);
        return readersList;
    }
}
