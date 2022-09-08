package com.booklibrary;

import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;
import com.booklibrary.service.TakenBookService;


import java.util.Scanner;


public class Menu {
    private BookService bookService = new BookService();
    private ReaderService readerService = new ReaderService();
    private TakenBookService takenBookService = new TakenBookService();

    public void start() {
        readerService.generateReaders();
        bookService.generateBooks();

        while (true) {
            showMenu();
            Scanner scanner = new Scanner(System.in);
            String c = scanner.nextLine();
            switch (c) {
                case "1" -> bookService.printAllBooks();
                case "2" -> readerService.printAllReaders();
                case "3" -> readerService.addNewReader();
                case "4" -> bookService.addNewBook();
                case "5" -> takenBookService.issueBook();
                case "6" -> takenBookService.removeBookFromReader();
                case "7" -> takenBookService.printCurrentReaderByBookId();
                case "8" -> takenBookService.printAllBooksTakenByReaderId();

                case "exit" -> {
                    System.out.println("Bay!");
                    System.exit(0);
                }

                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
            ;


        }
    }

    public void showMenu() {
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

