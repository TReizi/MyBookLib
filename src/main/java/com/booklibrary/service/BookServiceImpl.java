package com.booklibrary.service;

import com.booklibrary.dao.BookDAO;
import com.booklibrary.dao.BookDAOImpl;
import com.booklibrary.entity.Book;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookServiceImpl implements BookService {


  private final Scanner scanner = new Scanner(System.in);
  private final BookDAO bookDAO;

  public BookServiceImpl(BookDAOImpl bookDAO) {
    this.bookDAO = bookDAO;
  }

  //  public final void generateBooks() {
  //    Book b1 = new Book(1, "451 по Фаренгейту", "Рэй Брэдбери");
  //    Book b2 = new Book(2, "1984", "Рэй Джордж Оруэлл");
  //    Book b3 = new Book(3, "Мастер и Маргарита", "Михаил Булгаков");
  //    bookList.add(b1);
  //    bookList.add(b2);
  //    bookList.add(b3);
  //  }

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
  public Book findBookById(Long bookId) {
    return bookList.stream().filter(book -> book.getId() == bookId).findAny().orElse(null);
  }
}
