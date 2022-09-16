package com.booklibrary.service;

import com.booklibrary.UI.InputClient;
import com.booklibrary.dao.BorrowDao;
import com.booklibrary.dao.BorrowDAOImpl;
import com.booklibrary.entity.TakenBook;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class TakenBookServiceImpl implements TakenBookService {

  private final BookService bookService = new BookServiceImpl();
  private final ReaderService readerService = new ReaderServiceImpl();
  private final InputClient inputClient = new InputClient();
  private final BorrowDao borrowDAO = new BorrowDAOImpl(bookService, readerService);

  @Override
  public void issueBook() throws SQLException {
    var reader = readerService.findReaderById(inputClient.inputReaderId());
    var book = bookService.findBookById(inputClient.inputBookId());
    borrowDAO.addABookReader(reader, book);
    borrowDAO.statusBorrow("Взята", book);
    System.out.println(
        "Взял книгу: " + reader.getName() + ". По названию: " + book.getName() + ".");
  }

  @Override
  public void removeBookFromReader() throws SQLException {
    // Над этим методом думаю, как сделать так чтоб проверялось в базе взятых книг есть ли там
    // такоей айди или нет, если есть тогда удаляем книгу которую указываем
    var reader = readerService.findReaderById(inputClient.inputReaderId());

    borrowDAO.deleteBorrow(inputClient.inputBookId());
  }

  @Override
  public void printAllBooksTakenByReaderId() throws SQLException {
    var takenBook = new TakenBook();
    takenBook = filterByReader(inputClient.inputReaderId()).get(0);
    System.out.println("Читатель :" + takenBook.getReader().getName());
    System.out.println("Взята книга: " + takenBook.getBook().getName());
  }

  @Override
  public void printCurrentReaderByBookId() throws SQLException {
    var takenBook = filterByBook(inputClient.inputBookId()).get(0);
    System.out.println("Книга: " + takenBook.getBook().getName());
    System.out.println("Взята :" + takenBook.getReader().getName());
  }

  public List<TakenBook> filterByBook(long bookId) throws SQLException {
    return borrowDAO.findAllBorrow().stream()
        .filter(filterBook -> filterBook.getBook().getId() == bookId)
        .collect(Collectors.toList());
  }

  public List<TakenBook> filterByReader(long readerId) throws SQLException {
    return borrowDAO.findAllBorrow().stream()
        .filter(filterReader -> filterReader.getReader().getId() == readerId)
        .collect(Collectors.toList());
  }
}
