package com.booklibrary;

import com.booklibrary.Service.BookService;
import com.booklibrary.Service.ReadersService;
import com.booklibrary.Service.TakenBookService;

import static com.booklibrary.Menu.start;

public class Main {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в Библиотеку.");
        ReadersService.generateReaders();
        BookService.generateBooks();
        TakenBookService.generator();
        start();

        }
    }




