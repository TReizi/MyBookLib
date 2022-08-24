package com.booklibrary.level1;


import com.booklibrary.level1.Data.BookData;
import com.booklibrary.level1.Data.ReadersData;

import static com.booklibrary.level1.menu.start;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Библиотеку.");
        ReadersData.generateReaders();
        BookData.generateBooks();
        start();

        }
    }




