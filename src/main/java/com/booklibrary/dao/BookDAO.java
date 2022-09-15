package com.booklibrary.dao;

import com.booklibrary.entity.Book;

import java.sql.SQLException;
import java.util.List;

public interface BookDAO {
  List<Book> findAllBook() throws SQLException;

  void addBookDatabase(Book book) throws SQLException;
}
