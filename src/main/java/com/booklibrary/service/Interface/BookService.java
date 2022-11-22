package com.booklibrary.service.Interface;

import com.booklibrary.entity.Book;

import java.util.Optional;


public interface BookService {
  void printAllBooks();

  void addNewBook(String newBook);

  Optional<Book> findBookById(long bookId);
}
