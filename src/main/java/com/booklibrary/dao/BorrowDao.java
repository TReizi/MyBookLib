package com.booklibrary.dao;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;


import java.util.List;

public interface BorrowDao {

  void addABookReader(Reader reader, Book book) ;

  List<TakenBook> findAllBorrow() ;

  void deleteBorrow(long deleteBook);

  void statusBorrow(String status, Book bookid);
}
