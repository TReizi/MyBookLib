package com.booklibrary.service.implClass;

import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.dao.implDaoClass.BookDAOImpl;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.dataValidation.exceptionOutput.ExceptionServiceMethods;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.dao.implDaoClass.BorrowDAOImpl;
import com.booklibrary.entity.Reader;
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
    try {
      long readerLong = Long.parseLong(readerId);
      var takenBook = filterByReader(readerLong).get(0);
      System.out.println("Читатель взял книгу:  ");
      System.out.println(takenBook.getBook().toString());
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      System.err.println("Нет такого читателя.");
    }
  }

  @Override
  public void printCurrentReaderByBookId(String bookId) {
    // Тут 2 вариант, я просто не определился какой лучше, по этому на проверку отправляю 2

//
//    long bookLong = Long.parseLong(bookId);
//    if (bookDAO.findAll().isEmpty()) {
//      System.err.println("Такой книги нет в БИБЛИОТЕКИ");
//    }
//    if (!borrowDAO.filterByBook(bookLong).isEmpty()) {
//      borrowDAO.filterByBook(bookLong).forEach(System.out::println);
//    } else {
//      System.err.println("Эта книга не взята");
//    }

    try {
      long bookLong = Long.parseLong(bookId);
      var takenBook = filterByBook(bookLong).get(0);
      System.out.println("Книга взята читателем: ");
      System.out.println(takenBook.getReader().toString());
    } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
      System.err.println("Нет такой взятой книги.");
    }
  }

  @Override
  public void showAllReaderAndBooks() {
    try {
      borrowDAO
          .findAll()
          .forEach(((borrow) -> System.out.println(borrow.getReader() + " " + borrow.getBook())));
    } catch (NoSuchElementException e) {
      System.err.println("Ошибка, нет взятых книг читателями.");
    }
  }
  //-  метод если через for
  public List<Borrow> filterByBook(long bookId) {
    return borrowDAO.filterByBook(bookId);
  }
  //-  метод если через for
  public List<Borrow> filterByReader(long readerId) {
    return borrowDAO.filterByReader(readerId);
  }
}
