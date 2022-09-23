package com.booklibrary.dao;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;


import java.util.List;

public interface BorrowDAO {

  boolean addABookReader(Reader reader, Book book);

  List<TakenBook> findAllBorrow();

  boolean deleteBorrow(long deleteBook);

  boolean statusBorrow(String status, Book bookid);
}
