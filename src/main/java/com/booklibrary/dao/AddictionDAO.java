package com.booklibrary.dao;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;

import java.sql.SQLException;
import java.util.List;

public interface AddictionDAO {
  void addABookReader(Reader reader, Book book) throws SQLException;

  List<TakenBook> findAllAddiction() throws SQLException;

  void deleteAddication(long deleteBook) throws SQLException;

  void statusСhange(String status, Book bookid) throws SQLException;
}
