package com.BookLibrary.Level1.Data;

import com.BookLibrary.Level1.entity.Reader_object;

import java.util.ArrayList;

public class Readers_data {


    public static void GetAllReaders () {
        ArrayList<Reader_object> readersArray = new ArrayList<>();
        Reader_object r1 = new Reader_object(1, "Artem");
        Reader_object r2 = new Reader_object(2, "Oleg");
        Reader_object r3 = new Reader_object(3, "Nina");
        readersArray.add(r1);
        readersArray.add(r2);
        readersArray.add(r3);
        System.out.println(readersArray);

    }



}
