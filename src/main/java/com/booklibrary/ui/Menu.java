package com.booklibrary.ui;


import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.implClass.BookServiceImpl;
import com.booklibrary.service.implClass.ReaderServiceImpl;
import com.booklibrary.service.implClass.BorrowServiceImpl;
import com.booklibrary.service.Interface.BookService;
import com.booklibrary.service.Interface.BorrowService;
import com.booklibrary.service.Interface.ReaderService;


import java.util.Scanner;
import java.util.regex.Pattern;

import static com.booklibrary.exceptionOutput.ErrorMessagePrintService.userErrorOutput;

public class Menu {
    private final BookService bookService = new BookServiceImpl();
    private final ReaderService readerService = new ReaderServiceImpl();
    private final BorrowService borrowService = new BorrowServiceImpl();
    private final Scanner scanner = new Scanner(System.in);


    public void start() {

        while (true) {
            showMenu();
            String c = scanner.nextLine();
            switch (c) {
                case "1" -> printAllBooks();
                case "2" -> printAllReaders();
                case "3" -> addNewReader();
                case "4" -> addNewBook();
                case "5" -> issueBook();
                case "6" -> removeBookFromReader();
                case "7" -> printAllBooksTakenByReaderId();
                case "8" -> printCurrentReaderByBookId();
                case "9" -> showAllReaderAndBooks();
                case "exit" -> {
                    System.out.println("Bay!");
                    System.exit(0);
                }
                //пока что закоментировал, не знаю как решить проблему
//                default -> throw new IllegalStateException("Unexpected value: " + c);
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
                [9] Показать все взятые книги и их читателей.
                [exit] Выход.
                """;
        System.out.println(textMenu);
    }

    private void printAllBooks() {
        try {
            bookService.printAllBooks();
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getLocalizedMessage());
        }
    }

    private void printAllReaders() {
        try {
            readerService.printAllReaders();
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getLocalizedMessage());
        }
    }

    private void addNewReader() {
        System.out.println("Укажите имя нового читателя: ");
        String readerName = scanner.nextLine();
        var reader = new Reader(readerName);
        if (Pattern.compile("[0-9]").matcher(readerName).find()) {
            userErrorOutput();
        }
        readerService.addNewReader(reader);
    }

    private void addNewBook() {
        System.out.println("Укажите название книги и автора через /. ");
        String separatorBook = scanner.nextLine();
        if (separatorBook.contains("/")) {
            String[] separation = separatorBook.split("/");
            var book = new Book(separation);
            bookService.addNewBook(book);
        } else {
            userErrorOutput();
        }
    }

    private void issueBook() {
        System.out.println("Укажите id читателя: ");
        long readerId = scanner.nextInt();
        System.out.println("Укажите id книги: ");
        long bookId = scanner.nextInt();
        borrowService.issueBook(readerId, bookId);
    }

    private void removeBookFromReader() {
        try {
            System.out.println("Укажите id книги которую хотите вернуть: ");
            long bookId = scanner.nextInt();
            borrowService.removeBookFromReader(bookId);
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getLocalizedMessage());
        }
    }

    private void printAllBooksTakenByReaderId() {
        try {
            System.out.println("Введите id пользователя для просмотра: ");
            long readerID = scanner.nextInt();
            borrowService.printAllBooksTakenByReaderId(readerID);
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getLocalizedMessage());
        }
    }

    private void printCurrentReaderByBookId() {
        try {
            System.out.println("Введите id пользователя для просмотра: ");
            long bookId = scanner.nextInt();
            borrowService.printCurrentReaderByBookId(bookId);
        } catch (RuntimeException runtimeException) {
            System.err.println(runtimeException.getLocalizedMessage());
        }
    }

    private void showAllReaderAndBooks() {
        try {
            borrowService.showAllReaderAndBooks();
        } catch (RuntimeException e) {
            System.err.println(e.getLocalizedMessage());
        }
    }
}

