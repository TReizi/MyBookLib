package com.booklibrary.dao.implDaoClass;

import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.mockito.Mockito.*;

class BorrowDAOImplTest {

  private BorrowDAOImpl borrowDAO;

  @BeforeEach
  void setUp() {
    borrowDAO = mock(BorrowDAOImpl.class);
  }

  @DisplayName("Тест возвращения книги")
  @Test
  void deleteBorrow() {
    long bookId = 10;
    ArgumentCaptor<Long> bookIdCaptor = ArgumentCaptor.forClass(Long.class);
    when(borrowDAO.delete(bookIdCaptor.capture())).thenReturn(true);
    boolean flag = borrowDAO.delete(bookId);
    long bookIdDelete = bookIdCaptor.getValue();
    assertAll(
        () -> verify(borrowDAO, times(1)).delete(bookIdDelete),
        () -> assertThat(flag).isTrue(),
        () -> assertThat(bookIdDelete).isEqualTo(bookId));
  }

  @DisplayName("Тест добавления книги читателю")
  @Test
  void addABookReader() {
    var book = new Book(1000202, "Test name", "Test author", "Test status");
    var reader = new Reader(1000202, "Test name");
    long bookId = book.getId();
    long readerId = reader.getId();

    ArgumentCaptor<Book> bookIdCaptor = ArgumentCaptor.forClass(Book.class);
    ArgumentCaptor<Reader> readerIdCaptor = ArgumentCaptor.forClass(Reader.class);
    when(borrowDAO.borrowBookToReader(readerIdCaptor.capture(), bookIdCaptor.capture()))
        .thenReturn(true);
    boolean flag = borrowDAO.borrowBookToReader(reader, book);
    Book bookSave = bookIdCaptor.getValue();
    Reader readerSave = readerIdCaptor.getValue();
    assertAll(
        () -> verify(borrowDAO, times(1)).borrowBookToReader(readerSave, bookSave),
        () -> assertThat(flag).isTrue(),
        () -> assertThat(readerSave.getId()).isEqualTo(readerId),
        () -> assertThat(bookSave.getId()).isEqualTo(bookId));
  }
}
