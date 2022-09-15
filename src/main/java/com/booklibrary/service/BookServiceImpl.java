package com.booklibrary.service;

import com.booklibrary.dao.BookDAO;
import com.booklibrary.entity.Book;

import java.sql.SQLException;
import java.util.Scanner;

public class BookServiceImpl implements BookService {

  private final Scanner scanner = new Scanner(System.in);
  private final BookDAO bookDAO;

  public BookServiceImpl(BookDAO bookDAO) {
    this.bookDAO = bookDAO;
  }

  @Override
  public void printAllBooks() throws SQLException {
    System.out.println("Все книги: ");
    bookDAO.findAllBook().forEach(System.out::println);
  }

  @Override
  public void addNewBook() throws SQLException {
    System.out.println("Укажите название книги и автора черех /. ");
    String newBook = scanner.nextLine();
    String[] separation = newBook.split("/");
    var book = new Book(separation);
    bookDAO.addBookDatabase(book);
  }

  @Override
  public Book findBookById(Long bookId) throws SQLException {
    return bookDAO.findAllBook().stream()
        .filter(book -> book.getId() == bookId)
        .findAny()
        .orElse(null);
  }
}
