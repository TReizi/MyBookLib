package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.entity.Book;
import com.booklibrary.service.Interface.BookService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.booklibrary.dataValidation.DataValidation.stringDataValidation;

public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO = new BookDAOImpl();

  @Override
  public void printAllBooks() {
    if (!bookDAO.findAll().isEmpty()) {
      System.out.println("Все книги: ");
      bookDAO.findAll().forEach(System.out::println);
    } else {
      throw new NoSuchElementException("Ошибка, нет книг");
    }
  }

  @Override
  public void addNewBook(Book newBook) {
    if (!stringDataValidation(newBook.getAuthor())) bookDAO.save(newBook);
  }

  @Override
  public Optional<Book> findBookById(long bookId) {
    return bookDAO.findBookById(bookId);
  }
}
