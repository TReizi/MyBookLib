package com.booklibrary.service;

import java.sql.SQLException;

public interface TakenBookService {
  void issueBook() throws SQLException;

  void removeBookFromReader() throws SQLException;

  void printAllBooksTakenByReaderId() throws SQLException;

  void printCurrentReaderByBookId() throws SQLException;
}
