package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;

import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

public interface BorrowDAO {

  boolean borrowBookToReader(long readerID, long bookId);

  Map<Reader, List<Book>> findAll();

  boolean delete(long deleteBook, long idReader);

  List<Borrow> filterByReader(long readerId);

  List<Borrow> filterByBook(long bookId);

  Reader searchDAOReader(ResultSet resultSet);
}
