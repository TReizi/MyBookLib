package com.booklibrary.service;

import com.booklibrary.entity.Reader;

import java.util.*;

public class ReaderService {

    private static final ArrayList<Reader> readerList = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    //оставил только 2 генератора статик
    public static void generateReaders() {
        Reader r1 = new Reader(1, "Artem");
        Reader r2 = new Reader(2, "Oleg");
        Reader r3 = new Reader(3, "Nina");
        readerList.add(r1);
        readerList.add(r2);
        readerList.add(r3);

    }

    public void printAllReaders(){
        System.out.println("Все читатели: ");
        readerList.forEach(System.out::println);
    }

    public void addNewReader() {
        System.out.println("Укажите имя нового читателя: ");
        String readerName = scanner.nextLine();
        var reader = new Reader(readerName);
        readerList.add(reader);
    }




    public Reader findReaderById(Long readerId){
        return readerList.stream()
                .filter(reader-> reader.getId() == readerId)
                .findAny()
                .orElse(null);
    }


}
