package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.Interface.ReaderService;

import java.util.NoSuchElementException;
import java.util.Optional;

import static com.booklibrary.dataValidation.DataValidation.stringDataValidation;

public class ReaderServiceImpl implements ReaderService {

  private final ReaderDAO readerDAO = new ReaderDAOImpl();

  @Override
  public void printAllReaders() {
    try {
      System.out.println("Все читатели: ");
      readerDAO.findAll().forEach(System.out::println);
    } catch (NoSuchElementException e) {
      System.err.println("Ошибка, нет читателей.");
    }
  }

  @Override
  public void addNewReader(Reader newReader) {
    if (!stringDataValidation(newReader.getName())) readerDAO.save(newReader);
  }

  @Override
  public Optional<Reader> findReaderById(long readerId) {
    return readerDAO.findReaderById(readerId);
  }
}
