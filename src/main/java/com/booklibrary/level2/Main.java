package com.booklibrary.level2;

import com.booklibrary.level2.Data.BookData;
import com.booklibrary.level2.Data.ReadersData;
import com.booklibrary.level2.Data.TakenBooksData;

import static com.booklibrary.level2.Menu.start;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Библиотеку.");
        ReadersData.generateReaders();
        BookData.generateBooks();
        TakenBooksData.generateTakenReaderBooks();
        start();

        }
    }




