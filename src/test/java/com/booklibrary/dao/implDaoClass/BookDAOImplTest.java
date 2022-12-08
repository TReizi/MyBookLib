package com.booklibrary.dao.implDaoClass;

import com.booklibrary.entity.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class BookDAOImplTest {

  private BookDAOImpl bookDAO;

  @BeforeEach
  void setUp() {
    bookDAO = mock(BookDAOImpl.class);
  }

//  @DisplayName("Тест добавления книги в БД.")
//  @Test
//  void addBookDatabase() {
//    var book = new Book(1000202, "Test name", "Test author", "Test status");
//    ArgumentCaptor<Book> bookCaptor = ArgumentCaptor.forClass(Book.class);
//    when(bookDAO.save(bookCaptor.capture())).thenReturn(true);
//    boolean flag = bookDAO.save(book);
//    Book bookSave = bookCaptor.getValue();
//    assertAll(
//        () -> verify(bookDAO, times(1)).save(bookSave),
//        () -> assertThat(flag).isTrue(),
//        () -> assertThat(bookSave).isEqualTo(book));
//  }
}
