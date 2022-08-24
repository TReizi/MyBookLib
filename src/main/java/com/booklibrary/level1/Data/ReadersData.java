package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Reader;

import java.util.ArrayList;

public class ReadersData {

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

}
