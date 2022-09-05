package com.booklibrary.Service;

import com.booklibrary.entity.Reader;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

public class ReaderService {

    private static ArrayList<Reader> readersList = new ArrayList<>();
    private static Scanner readersEnter = new Scanner(System.in);
    private static final AtomicLong newId = new AtomicLong(1000);


    public static ArrayList <Reader> getReadersArrayList() {
        return readersList;
    }

    public static void generateReaders() {
        Reader r1 = new Reader(1, "Artem");
        Reader r2 = new Reader(2, "Oleg");
        Reader r3 = new Reader(3, "Nina");
        readersList.add(r1);
        readersList.add(r2);
        readersList.add(r3);

    }

    public static void printAllReaders(){
        System.out.println("Все читатели: ");
        readersList.forEach(System.out::println);
    }

    public static void addNewReader() {
        System.out.println("Укажите имя нового читателя: ");
        String readersName = readersEnter.nextLine();
        Reader reader = new Reader();
        reader.setName(readersName);
        reader.setId(newId.incrementAndGet());
        readersList.add(reader);
    }

    public static List<Reader> searchReader(ArrayList<Reader> idSearchReader, long needReaderId) {
        return getReadersArrayList().stream()
                .filter((searchReader)->searchReader.getId() == needReaderId)
                .collect(Collectors.toList());
    }

    public static Reader findReaderById(Long readerId){
        return readersList.stream()
                .filter(reader-> reader.getId() == readerId)
                .findAny()
                .orElse(null);
    }


}
