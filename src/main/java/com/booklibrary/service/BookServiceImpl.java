package com.booklibrary.service;

import com.booklibrary.UI.InputClient;
import com.booklibrary.dao.BookDAO;
import com.booklibrary.dao.BookDAOImpl;
import com.booklibrary.entity.Book;

public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO = new BookDAOImpl();
  private final InputClient inputClient = new InputClient();

  @Override
  public void printAllBooks() {
    System.out.println("Все книги: ");
    bookDAO.findAllBook().forEach(System.out::println);
  }

  @Override
  public void addNewBook() {
    System.out.println("Укажите название книги и автора черех /. ");
    var book = new Book(inputClient.inputClientAddBook());
    bookDAO.addBookDatabase(book);
  }

  @Override
  public Book findBookById(Long bookId) {
    return bookDAO.findAllBook().stream()
        .filter(book -> book.getId() == bookId)
        .findAny()
        .orElse(null);
  }
}
