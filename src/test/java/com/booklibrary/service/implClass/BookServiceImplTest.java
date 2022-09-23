package com.booklibrary.service.implClass;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookServiceImplTest {
  private BookServiceImpl bookService;

  @BeforeEach
  void setUp() {
    System.out.println("Before Each");
    bookService = new BookServiceImpl();
  }

  @Test
  void printAllBooks() {
   bookService.printAllBooks();
  }

  @Test
  void addNewBook() {

    bookService.addNewBook();

  }

  @Test
  void findBookById() {}
}
