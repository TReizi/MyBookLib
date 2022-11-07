package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Reader;

import java.util.List;
import java.util.Optional;

public interface ReaderDAO {
  List<Reader> findAll();

  boolean save(Reader reader);

 Optional <Reader> findReaderById(long readerId);


}
