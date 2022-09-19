package com.booklibrary.dao;

import com.booklibrary.entity.Book;

import java.util.List;

public interface BookDAO {

  List<Book> findAllBook() ;

  void addBookDatabase(Book book);
}
