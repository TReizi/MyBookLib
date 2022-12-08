package com.booklibrary.service.Interface;

import com.booklibrary.entity.Borrow;

import java.util.List;

public interface BorrowService {
  boolean issueBook(String readerId, String bookId);

  void removeBookFromReader(String bookId, String readerId);

  void printAllBooksTakenByReaderId(String readerId);

  void printCurrentReaderByBookId(String book);

  void showAllReaderAndBooks();

  List<Borrow> filterByBook(long bookId);

  List<Borrow> filterByReader(long readerId);
}
