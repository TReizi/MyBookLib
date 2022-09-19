package com.booklibrary.service;

import com.booklibrary.entity.Book;

import java.sql.SQLException;

public interface BookService {
  void printAllBooks();

  void addNewBook();

  Book findBookById(Long bookId);
}
