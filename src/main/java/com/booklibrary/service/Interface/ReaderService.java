package com.booklibrary.service.Interface;

import com.booklibrary.entity.Reader;

public interface ReaderService {
  void printAllReaders();

  void addNewReader(Reader nameReader);

  Reader findReaderById(long readerId);
}
