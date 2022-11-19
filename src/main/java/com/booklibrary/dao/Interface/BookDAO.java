package com.booklibrary.dao.Interface;

import com.booklibrary.entity.Book;

import java.util.List;
import java.util.Optional;

public interface BookDAO {

  List<Book> findAll();

  boolean save(Book book);

  Optional<Book> findBookById(Long bookId);
}
