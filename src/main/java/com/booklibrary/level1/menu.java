package com.booklibrary.level1;


import java.util.Scanner;


import static com.booklibrary.level1.Data.BookData.*;
import static com.booklibrary.level1.Data.ReadersData.addNewReaders;
import static com.booklibrary.level1.Data.ReadersData.getAllReaders;


public class menu {
    public static void start() {
        while (true) {
            textMenu();

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();
            Object value = switch (c) {
                case "1" -> getAllBooks();
                case "2" -> getAllReaders();
                case "3" -> addNewReaders();
                case "4" -> addNewBook();


                case "exit" -> exit();

                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

        }
    }

    public static int exit() {
        System.out.println("Bay!");
        System.exit(0);
        return exit();
    }


    public static void textMenu() {
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

