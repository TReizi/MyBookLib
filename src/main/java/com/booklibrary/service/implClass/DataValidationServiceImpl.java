package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.Interface.DataValidationService;

public class DataValidationServiceImpl implements DataValidationService {
  private final ReaderDAO readerDAO = new ReaderDAOImpl();
  private final BookDAO bookDAO = new BookDAOImpl();

  @Override
  public boolean validationReader(long readerId) {
    var reader = new Reader();
    reader = readerDAO.findReaderById(readerId);
    if (reader != null) {
      return true;
    } else {
      System.out.println("False!");
      return false;
    }
  }

  @Override
  public boolean validationBook(long bookId) {
    var book = new Book();
    book = bookDAO.findBookById(bookId);
    if (book != null) {
      return true;
    } else {
      System.out.println("False!");
      return false;
    }
  }
}
