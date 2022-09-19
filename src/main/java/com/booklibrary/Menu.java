package com.booklibrary;


import com.booklibrary.service.*;

import java.util.Scanner;

public class Menu {
    private final BookService bookService = new BookServiceImpl();
    private final ReaderService readerService = new ReaderServiceImpl();
    private final TakenBookService takenBookService = new TakenBookServiceImpl();



    public void start() {

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
                case "7" -> takenBookService.printAllBooksTakenByReaderId();
                case "8" -> takenBookService.printCurrentReaderByBookId();

                case "exit" -> {
                    System.out.println("Bay!");
                    System.exit(0);
                }
                default -> throw new IllegalStateException("Unexpected value: " + c);
            }
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

