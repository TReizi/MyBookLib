package com.booklibrary.level1.Data;

import com.booklibrary.level1.entity.Reader;

import java.util.ArrayList;

public class ReadersData {

    public static ArrayList<Reader> readerArrayList() {
        ArrayList<Reader> readersArray = new ArrayList<>();
        Reader r1 = new Reader(1, "Artem");
        Reader r2 = new Reader(2, "Oleg");
        Reader r3 = new Reader(3, "Nina");
        readersArray.add(r1);
        readersArray.add(r2);
        readersArray.add(r3);
        return readersArray;
    }

    public static ArrayList<Reader> getAllReaders(ArrayList<Reader> readersArray) {
        System.out.println("Все читатели: ");
        for (Reader r : readersArray) {
            System.out.println(r);
        }
        return readersArray;

    }

}
