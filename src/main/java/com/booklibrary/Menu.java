package com.booklibrary;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.BookDAOImpl;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.dao.ReaderDAOImpl;
import com.booklibrary.service.BookServiceImpl;
import com.booklibrary.service.ReaderServiceImpl;
import com.booklibrary.service.TakenBookServiceImpl;


import java.sql.SQLException;
import java.util.Scanner;


public class Menu {
    private final ConnectionSettingsData connectionSettingsData = new ConnectionSettingsData();
    private final BookDAOImpl bookDAO = new BookDAOImpl(connectionSettingsData);
    private final ReaderDAOImpl readerDAO = new ReaderDAOImpl(connectionSettingsData);
    private final BookServiceImpl bookService = new BookServiceImpl(bookDAO);
    private final ReaderServiceImpl readerService = new ReaderServiceImpl(readerDAO);
    private final TakenBookServiceImpl takenBookService = new TakenBookServiceImpl(bookService,readerService);

    public void start() throws SQLException {

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

