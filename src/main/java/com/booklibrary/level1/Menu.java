package com.booklibrary.level1;

import java.util.Scanner;


import static com.booklibrary.level1.Data.BookData.*;
import static com.booklibrary.level1.Data.ReadersData.*;

public class Menu {
    public static void start() {
        while (true) {
            showMenu();

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();
            switch (c) {
                case "1" -> printAllBooks();
                case "2" -> printAllReaders();


                case "exit" -> {
                    System.out.println("Bay!");
                    System.exit(0);
                }

                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

        }
    }

    public static void showMenu() {
        String textMenu = """
                Меню библиотеки:
                [1] Список всех книг.
                [2] Список всех читателей.

                [exit] Выход.
                """;
        System.out.println(textMenu);

    }
}

