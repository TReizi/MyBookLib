package com.booklibrary.service.Interface;

import com.booklibrary.entity.Reader;

import java.util.Optional;

public interface ReaderService {
  void printAllReaders();

  void addNewReader(Reader nameReader);

  Optional<Reader> findReaderById(long readerId);
}
