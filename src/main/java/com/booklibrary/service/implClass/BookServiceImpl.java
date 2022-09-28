package com.booklibrary.service.implClass;

import com.booklibrary.ui.InputClient;
import com.booklibrary.dao.BookDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.entity.Book;
import com.booklibrary.service.BookService;

public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO = new BookDAOImpl();
  private final InputClient inputClient = new InputClient();

  @Override
  public void printAllBooks() {
    System.out.println("Все книги: ");
    bookDAO.findAll().forEach(System.out::println);
  }

  @Override
  public void addNewBook() {
    System.out.println("Укажите название книги и автора через /. ");
    var book = new Book(inputClient.inputClientAddBook());
    bookDAO.save(book);
  }

  @Override
  public Book findBookById(Long bookId) {
    return bookDAO.findAll().stream()
        .filter(book -> book.getId() == bookId)
        .findAny()
        .orElse(null);
  }
}
