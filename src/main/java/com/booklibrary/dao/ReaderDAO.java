package com.booklibrary.dao;

import com.booklibrary.entity.Reader;

import java.util.List;

public interface ReaderDAO {
  List<Reader> findAllReader();

  boolean addReaderDatabase(Reader reader);
}
