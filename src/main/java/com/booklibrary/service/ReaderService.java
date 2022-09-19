package com.booklibrary.service;

import com.booklibrary.entity.Reader;

public interface ReaderService {
  void printAllReaders();

  void addNewReader();

  Reader findReaderById(Long readerId);
}
