package com.booklibrary;

import com.booklibrary.Service.BookService;
import com.booklibrary.Service.ReaderService;
import com.booklibrary.Service.TakenBookService;


import java.util.Scanner;


public class Menu {
    public  void start() {
        while (true) {
            showMenu();

            Scanner scanner = new Scanner(System.in);
            String c = scanner.nextLine();
            switch (c) {
                case "1" -> new BookService().printAllBooks();
                case "2" -> new ReaderService().printAllReaders();
                case "3" -> new ReaderService().addNewReader();
                case "4" -> new BookService().addNewBook();
                case "5" -> new TakenBookService().issueBook();
                case "6" -> new TakenBookService().removeBookFromReader();
                case "7" -> new TakenBookService().printCurrentReaderByBookId();
                case "8" -> new TakenBookService().printAllBooksTakenByReaderId();

                case "exit" -> {
                    System.out.println("Bay!");
                    System.exit(0);
                }

                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

        }
    }

    public  void showMenu() {
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

