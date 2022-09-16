package com.booklibrary.dao;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;

import java.sql.SQLException;
import java.util.List;

public interface BorrowDao {
  void addABookReader(Reader reader, Book book) throws SQLException;

  List<TakenBook> findAllBorrow() throws SQLException;

  void deleteBorrow(long deleteBook) throws SQLException;

  void statusBorrow(String status, Book bookid) throws SQLException;
}
