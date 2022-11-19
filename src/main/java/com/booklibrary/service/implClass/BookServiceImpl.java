package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.entity.Book;
import com.booklibrary.service.Interface.BookService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.booklibrary.dataValidation.DataValidation.stringDataValidation;
import static com.booklibrary.dataValidation.DataValidation.validationNullString;

public class BookServiceImpl implements BookService {

  private final BookDAO bookDAO = new BookDAOImpl();

  @Override
  public void printAllBooks() {
    try{
      System.out.println("Все книги: ");
      bookDAO.findAll().forEach(System.out::println);
    }catch (NoSuchElementException noSuchElementException){
      throw new NoSuchElementException("Ошибка, нет книг");
    }
  }

  @Override
  public void addNewBook(Book newBook) {
    if (!stringDataValidation(newBook.getAuthor()) && !newBook.getAuthor().isEmpty()) bookDAO.save(newBook);
  }

  @Override
  public Optional<Book> findBookById(long bookId) {
    return bookDAO.findBookById(bookId);
  }
}
