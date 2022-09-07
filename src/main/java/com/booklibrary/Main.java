package com.booklibrary;

import com.booklibrary.Service.BookService;
import com.booklibrary.Service.ReaderService;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Библиотеку.");
        ReaderService.generateReaders();
        BookService.generateBooks();
        new Menu().start();

        }
    }




