package com.booklibrary.dao.implDaoClass;

import com.booklibrary.entity.Reader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

class ReaderDAOImplTest {
  ReaderDAOImpl readerDAO;

  @BeforeEach
  void setUp() {
    readerDAO = mock(ReaderDAOImpl.class);
  }

  @DisplayName("Тест добавления читателя в БД.")
  @Test
  void addReaderDatabase() {
    var reader = new Reader(11234, "Test name");
    ArgumentCaptor<Reader> readerArgumentCaptor = ArgumentCaptor.forClass(Reader.class);
    when(readerDAO.save(readerArgumentCaptor.capture())).thenReturn(true);
    boolean flag = readerDAO.save(reader);
    Reader readerSave = readerArgumentCaptor.getValue();
    assertAll(
        () -> verify(readerDAO, times(1)).save(readerSave),
        () -> assertThat(flag).isTrue(),
        () -> assertThat(readerSave).isEqualTo(reader));
  }
}
