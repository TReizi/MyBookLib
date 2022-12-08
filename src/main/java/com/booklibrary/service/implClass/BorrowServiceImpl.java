package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.exceptionOutput.ExceptionServiceMethods;
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
  public boolean issueBook(String readerId, String bookId) {
    long readerLong = Long.parseLong(readerId);
    long bookLong = Long.parseLong(bookId);
    if (readerDAO.findReaderById(readerLong).isPresent()
        && bookDAO.findBookById(bookLong).isPresent()) {
      return borrowDAO.borrowBookToReader(readerLong, bookLong);
    } else {
      throw new ExceptionServiceMethods("exception Service method issueBook");
    }
  }

  @Override
  public void removeBookFromReader(String bookId, String readerId) {
    long bookLong = Long.parseLong(bookId);
    long readerLong = Long.parseLong(readerId);
    borrowDAO.delete(bookLong, readerLong);
  }

  @Override
  public void printAllBooksTakenByReaderId(String readerId) {
    long readerLong = Long.parseLong(readerId);
    var takenBook = filterByReader(readerLong).get(0);
    if (takenBook.getReader() != null) {
      System.out.println("Читатель взял книгу:  ");
      System.out.println(takenBook.getBook().toString());
    } else {
      System.out.println("Нет такого читателя.");
    }
  }

  @Override
  public void printCurrentReaderByBookId(String bookId) {
    long bookLong = Long.parseLong(bookId);
    var takenBook = filterByBook(bookLong).get(0);
    if (takenBook.getBook() != null) {
      System.out.println("Книга взята читателем: ");
      System.out.println(takenBook.getReader().toString());
    } else {
      System.out.println("Нет такой взятой книги.");
    }
  }

  @Override
  public void showAllReaderAndBooks() {
    if (!borrowDAO.findAll().isEmpty()) {
      borrowDAO
          .findAll()
          .forEach(((borrow) -> System.out.println(borrow.getReader() + " " + borrow.getBook())));
    } else {
      System.out.println("Читатели не взяли книги.");
    }
  }

  public List<Borrow> filterByBook(long bookId) {
    return borrowDAO.filterByBook(bookId);
  }

  public List<Borrow> filterByReader(long readerId) {
    return borrowDAO.filterByReader(readerId);
  }
}
