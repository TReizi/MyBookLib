package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Reader;

import java.util.*;

public class ReadersData {

    private static final ArrayList<Reader> readersList = new ArrayList<>();

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
}
