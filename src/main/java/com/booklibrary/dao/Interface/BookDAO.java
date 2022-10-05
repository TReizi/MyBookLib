package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Book;

import java.sql.ResultSet;
import java.util.List;

public interface BookDAO {

  List<Book> findAll();

  boolean save(Book book);

  Book findBookById(Long bookId);

  Book searchBook(ResultSet resultSet);
}
