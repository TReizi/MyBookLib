package com.booklibrary.ui;


import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.implClass.BookServiceImpl;
import com.booklibrary.service.implClass.ReaderServiceImpl;
import com.booklibrary.service.implClass.BorrowServiceImpl;
import com.booklibrary.service.Interface.BookService;
import com.booklibrary.service.Interface.BorrowService;
import com.booklibrary.service.Interface.ReaderService;


import java.util.NoSuchElementException;
import java.util.Scanner;



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
//                пока что закоментировал, не знаю как решить проблему
//               default -> throw new IllegalStateException("Unexpected value: " + c);
            }
        }
    }

    public void showMenu() {
        System.out.println("""
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
                """);

    }

    private void printAllBooks() {
        try {
            bookService.printAllBooks();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }

    private void printAllReaders() {
        try {
            readerService.printAllReaders();
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }

    private void addNewReader() {
        System.out.println("Укажите имя нового читателя: ");
        String readerName = scanner.nextLine();
            try{
               var reader = new Reader(readerName);
               readerService.addNewReader(reader);
            }catch (RuntimeException e){
                System.out.println("Ошибка в добавление нового пользователя.");
            }

    }

    private void addNewBook() {
        System.out.println("Укажите название книги и автора через /. ");
        String separatorBook = scanner.nextLine();
        try{
            bookService.addNewBook(separatorBook);

        }catch (ArrayIndexOutOfBoundsException arrayIndexOutOfBoundsException){
            System.err.println(arrayIndexOutOfBoundsException.getLocalizedMessage());
        }
    }

    private void issueBook() {
        System.out.println("Укажите id читателя: ");
        String readerId = scanner.nextLine();
        System.out.println("Укажите id книги: ");
        String bookId = scanner.nextLine();
        borrowService.issueBook(readerId, bookId);
    }

    private void removeBookFromReader() {
        try {
            System.out.println("Укажите id книги которую хотите вернуть: ");
            String bookId = scanner.nextLine();
            System.out.println("Укажите id читателя у кого взята книга: ");
            String readerId = scanner.nextLine();
            borrowService.removeBookFromReader(bookId,readerId);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }

    private void printAllBooksTakenByReaderId() {
        try {
            System.out.println("Введите id пользователя для просмотра: ");
            String readerID = scanner.nextLine();
            borrowService.printAllBooksTakenByReaderId(readerID);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }

    private void printCurrentReaderByBookId() {
        try {
            System.out.println("Введите id книги для просмотра: ");
            String bookId = scanner.nextLine();
            borrowService.printCurrentReaderByBookId(bookId);
        } catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }

    private void showAllReaderAndBooks() {
        try {
            borrowService.showAllReaderAndBooks();
        }  catch (NoSuchElementException noSuchElementException) {
            System.err.println(noSuchElementException.getLocalizedMessage());
        }
    }
}

