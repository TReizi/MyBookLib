package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Reader;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;


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



}
