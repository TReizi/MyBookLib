package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.entity.Borrow;
import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.dao.implDaoClass.BorrowDAOImpl;
import com.booklibrary.service.Interface.BorrowService;
import com.booklibrary.service.Interface.DataValidationService;

import java.util.List;
import java.util.NoSuchElementException;

public class BorrowServiceImpl implements BorrowService {

  private final BorrowDAO borrowDAO = new BorrowDAOImpl();
  private final BookDAO bookDAO = new BookDAOImpl();
  private final ReaderDAO readerDAO = new ReaderDAOImpl();
  private final DataValidationService dataValidationService = new DataValidationServiceImpl();

  @Override
  public void issueBook(long readerId, long bookId) {
    if (dataValidationService.validationReader(readerId) == true
        && dataValidationService.validationBook(bookId) == true) {
      borrowDAO.borrowBookToReader(readerId, bookId);
    } else {
      throw new NoSuchElementException(
          "Ошибка,\n"
              +"Книга в базе: "+dataValidationService.validationBook(bookId)
              + "\n "
              + "Читатель в базе: "+dataValidationService.validationReader(readerId));
    }
  }

  @Override
  public void removeBookFromReader(long bookId) {
    borrowDAO.delete(bookId);
  }

  @Override
  public void printAllBooksTakenByReaderId(long readerId) {
    var takenBook = filterByReader(readerId).get(0);
    System.out.println(
        "Читатель:" + readerDAO.findReaderById(takenBook.getReader().getId()).getName());
    System.out.println(
        "Взята книга: " + bookDAO.findBookById(takenBook.getBook().getId()).getName());
  }

  @Override
  public void printCurrentReaderByBookId(long bookId) {
    var takenBook = filterByBook(bookId).get(0);
    System.out.println("Книга: " + bookDAO.findBookById(takenBook.getBook().getId()).getName());
    System.out.println(
        "Взята:" + readerDAO.findReaderById(takenBook.getReader().getId()).getName());
  }

  @Override
  public void showAllReaderAndBooks() {
    if (!borrowDAO.findAll().isEmpty()) {
      borrowDAO.findAll().forEach((borrow -> System.out.println(borrow)));
    } else {
      throw new NoSuchElementException("Ошибка, нет взятых книг читателями.");
    }
  }

  public List<Borrow> filterByBook(long bookId) {
    return borrowDAO.filterByBook(bookId);
  }

  public List<Borrow> filterByReader(long readerId) {
    return borrowDAO.filterByReader(readerId);
  }
}
