package com.booklibrary.dao;

import com.booklibrary.entity.Reader;

import java.sql.SQLException;
import java.util.List;

public interface ReaderDAO {
  List<Reader> findAllReader() throws SQLException;

  void addReaderDatabase(Reader reader) throws SQLException;
}
