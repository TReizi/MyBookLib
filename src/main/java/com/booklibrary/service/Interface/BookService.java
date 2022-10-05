package com.booklibrary.service.Interface;

import com.booklibrary.entity.Book;


public interface BookService {
  void printAllBooks();

  void addNewBook(Book newBook);

  Book findBookById(long bookId);
}
