package com.booklibrary.service;

import com.booklibrary.dao.BorrowDao;
import com.booklibrary.dao.BorrowDAOImpl;
import com.booklibrary.entity.TakenBook;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class TakenBookServiceImpl implements TakenBookService {

  private final Scanner scanner = new Scanner(System.in);
  private final BookService bookService = new BookServiceImpl();
  private final ReaderService readerService = new ReaderServiceImpl();
  private final BorrowDao borrowDAO = new BorrowDAOImpl(bookService, readerService);

  @Override
  public void issueBook() throws SQLException {
    System.out.println("Укажите id читателя: ");
    long readerId = scanner.nextInt();
    System.out.println("Укажите id книги: ");
    long bookId = scanner.nextInt();
    var reader = readerService.findReaderById(readerId);
    var book = bookService.findBookById(bookId);
    borrowDAO.addABookReader(reader, book);
    borrowDAO.statusСhange("Взята", book);
    System.out.println(
        "Взял книгу: " + reader.getName() + ". По названию: " + book.getName() + ".");
  }

  @Override
  public void removeBookFromReader() throws SQLException {
    System.out.println("Укажите id читателя для возврата книги: ");
    long readerId = scanner.nextInt();
    var reader = readerService.findReaderById(readerId);
    System.out.println("Укажите id книги для возврата: ");
    long bookId = scanner.nextInt();
    System.out.println(reader.getName() + "Вернул книгу");
    System.out.println(filterByBook(bookId).toString());
    //    addictionDAO.statusСhange("Можно брать",(Book)filterByBook(bookId));

    borrowDAO.deleteAddication(bookId);
  }

  @Override
  public void printAllBooksTakenByReaderId() throws SQLException {
    System.out.println("Укажите id читателя: ");
    long idSearchReaders = scanner.nextInt();
    var takenBook = new TakenBook();
    takenBook = filterByReader(idSearchReaders).get(0);
    System.out.println("Читатель :" + takenBook.getReader().getName());
    System.out.println("Взята книга: " + takenBook.getBook().getName());
  }

  @Override
  public void printCurrentReaderByBookId() throws SQLException {
    System.out.println("Укажите id книги: ");
    long bookId = scanner.nextInt();
    var takenBook = filterByBook(bookId).get(0);
    System.out.println("Книга: " + takenBook.getBook().getName());
    System.out.println("Взята :" + takenBook.getReader().getName());
  }

  public List<TakenBook> filterByBook(long bookId) throws SQLException {
    return borrowDAO.findAllAddiction().stream()
        .filter(filterBook -> filterBook.getBook().getId() == bookId)
        .collect(Collectors.toList());
  }

  public List<TakenBook> filterByReader(long readerId) throws SQLException {
    return borrowDAO.findAllAddiction().stream()
        .filter(filterReader -> filterReader.getReader().getId() == readerId)
        .collect(Collectors.toList());
  }
}
