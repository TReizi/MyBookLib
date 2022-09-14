package com.booklibrary.service;

import com.booklibrary.entity.Reader;

import java.sql.SQLException;

public interface ReaderService {
  void printAllReaders() throws SQLException;

  void addNewReader() throws SQLException;

  Reader findReaderById(Long readerId) throws SQLException;
}
