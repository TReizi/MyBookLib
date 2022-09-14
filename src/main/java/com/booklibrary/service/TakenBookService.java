package com.booklibrary.service;

public interface TakenBookService {
  void issueBook();

  void removeBookFromReader();

  void printAllBooksTakenByReaderId();

  void printCurrentReaderByBookId();
}
