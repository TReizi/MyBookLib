package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.Interface.ReaderService;

public class ReaderServiceImpl implements ReaderService {

  private final ReaderDAO readerDAO = new ReaderDAOImpl();


  @Override
  public void printAllReaders() {
    System.out.println("Все читатели: ");
    readerDAO.findAll().forEach(System.out::println);
  }

  @Override
  public void addNewReader(Reader newReader) {
    readerDAO.save(newReader);
  }

  @Override
  public Reader findReaderById(long readerId) {
    return readerDAO.findReaderById(readerId);
  }
}
