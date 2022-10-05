package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;

import java.sql.ResultSet;
import java.util.List;

public interface BorrowDAO {

  boolean borrowBookToReader(long readerID, long bookId);

  List<Borrow> findAll();

  boolean delete(long deleteBook);

  boolean statusBorrow(String status, long bookId);

  List<Borrow> filterByReader(long readerId);

  List<Borrow> filterByBook(long bookId);

  Reader searchDAOReader(ResultSet resultSet);
}
