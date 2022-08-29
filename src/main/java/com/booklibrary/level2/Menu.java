package com.booklibrary.level2;

import java.util.Scanner;


import static com.booklibrary.level2.Data.BookData.*;
import static com.booklibrary.level2.Data.ReadersData.*;
import static com.booklibrary.level2.Data.TakenBooksData.*;

public class Menu {
    public static void start() {
        while (true) {
            showMenu();

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();
            switch (c) {
                case "1" -> printAllBooks();
                case "2" -> printAllReaders();
                case "3" -> addNewReaders();
                case "4" -> addNewBook();
                case "5" -> addBooksReader();
                case "6" -> removingBooksFromTheReader();
                case "7" -> getReaderBooks();
                case"8" ->getBookReader();

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
                [3] Добавить нового читателя.
                [4] Добавить новую книгу.
                [5] Взять книгу.
                [6] Вернуть книгу.
                [7] Показать все взятые книги по ID пользователя.
                [8] Показать текущего читателя книги по ID книги.
                [exit] Выход.
                """;
        System.out.println(textMenu);

    }
}

