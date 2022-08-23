package com.booklibrary.level1;


import java.util.Scanner;


import static com.booklibrary.level1.Data.BookData.*;
import static com.booklibrary.level1.Data.BookData.arrayListBooks;
import static com.booklibrary.level1.Data.ReadersData.getAllReaders;
import static com.booklibrary.level1.Data.ReadersData.readerArrayList;


public class menu {
    public static void start() {
        while (true) {
            System.out.println("Меню библиотеки: ");
            System.out.println("1 - все книги в Библиотеке");
            System.out.println("2 - все читатели в Библиотеке");
            System.out.println("exit - ВЫХОД");

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();
            Object value = switch (c) {
                case "1" -> getAllBooks(arrayListBooks());
                case "2" -> getAllReaders(readerArrayList());



                case "exit" ->exit();

                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

        }
    }

    public static int exit() {
        System.out.println("Bay!");
        System.exit(0);
        return exit();
    }
}

