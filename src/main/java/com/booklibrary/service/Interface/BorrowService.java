package com.booklibrary.service.Interface;

import com.booklibrary.entity.Borrow;

import java.util.List;

public interface BorrowService {
  boolean issueBook(long readerId, long bookId);

  void removeBookFromReader(long bookId, long readerId);

  void printAllBooksTakenByReaderId(long readerId);

  void printCurrentReaderByBookId(long book);

  void showAllReaderAndBooks();

  List<Borrow> filterByBook(long bookId);

  List<Borrow> filterByReader(long readerId);
}
