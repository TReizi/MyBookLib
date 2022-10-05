package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Reader;

import java.sql.ResultSet;
import java.util.List;

public interface ReaderDAO {
  List<Reader> findAll();

  boolean save(Reader reader);

  Reader findReaderById(long readerId);

  Reader searchReader(ResultSet resultSet);
}
