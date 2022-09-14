package com.booklibrary.service;

import com.booklibrary.entity.Book;

import java.sql.SQLException;

public interface BookService {
  void printAllBooks() throws SQLException;

  void addNewBook() throws SQLException;

  Book findBookById(Long bookId);
}
