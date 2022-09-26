package com.booklibrary.service;

public interface BorrowService {
  void issueBook();

  void removeBookFromReader();

  void printAllBooksTakenByReaderId();

  void printCurrentReaderByBookId();
}
