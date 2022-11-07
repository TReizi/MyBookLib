package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.dataValidation.exceptionOutput.ExceptionServiceMethods;
import com.booklibrary.entity.Borrow;
import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.dao.implDaoClass.BorrowDAOImpl;
import com.booklibrary.service.Interface.BorrowService;

import java.util.List;
import java.util.NoSuchElementException;

public class BorrowServiceImpl implements BorrowService {

  private final BorrowDAO borrowDAO = new BorrowDAOImpl();
  private final BookDAO bookDAO = new BookDAOImpl();
  private final ReaderDAO readerDAO = new ReaderDAOImpl();

  @Override
  public boolean issueBook(long readerId, long bookId) {
    if (readerDAO.findReaderById(readerId).isPresent()
        && bookDAO.findBookById(bookId).isPresent()) {
      return borrowDAO.borrowBookToReader(readerId, bookId);
    } else {
      throw new ExceptionServiceMethods("exception Service method issueBook");
    }
  }

  @Override
  public void removeBookFromReader(long bookId, long readerId) {
    borrowDAO.delete(bookId, readerId);
  }

  @Override
  public void printAllBooksTakenByReaderId(long readerId) {
    var takenBook = filterByReader(readerId).get(0);
    System.out.println("Читатель:" + readerDAO.findReaderById(takenBook.getReader().getId()));
    System.out.println("Взята книга: " + bookDAO.findBookById(takenBook.getBook().getId()));
  }

  @Override
  public void printCurrentReaderByBookId(long bookId) {
    var takenBook = filterByBook(bookId).get(0);
    System.out.println("Книга: " + bookDAO.findBookById(takenBook.getBook().getId()));
    System.out.println("Взята:" + readerDAO.findReaderById(takenBook.getReader().getId()));
  }

  @Override
  public void showAllReaderAndBooks() {
    try {
      borrowDAO.findAll().forEach(((reader, books) -> System.out.println(reader + " " + books)));
    } catch (NoSuchElementException e) {
      System.err.println("Ошибка, нет взятых книг читателями.");
    }
  }

  public List<Borrow> filterByBook(long bookId) {
    return borrowDAO.filterByBook(bookId);
  }

  public List<Borrow> filterByReader(long readerId) {
    return borrowDAO.filterByReader(readerId);
  }
}
