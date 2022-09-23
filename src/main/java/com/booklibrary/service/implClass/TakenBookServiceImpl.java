package com.booklibrary.service.implClass;

import com.booklibrary.ui.InputClient;
import com.booklibrary.dao.BorrowDAO;
import com.booklibrary.dao.implDaoClass.BorrowDAOImpl;
import com.booklibrary.entity.TakenBook;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;
import com.booklibrary.service.TakenBookService;

import java.util.List;
import java.util.stream.Collectors;

public class TakenBookServiceImpl implements TakenBookService {

  private final BookService bookService = new BookServiceImpl();
  private final ReaderService readerService = new ReaderServiceImpl();
  private final InputClient inputClient = new InputClient();
  private final BorrowDAO borrowDAO = new BorrowDAOImpl(bookService, readerService);

  @Override
  public void issueBook() {
    var reader = readerService.findReaderById(inputClient.inputReaderId());
    var book = bookService.findBookById(inputClient.inputBookId());
    borrowDAO.addABookReader(reader, book);
    borrowDAO.statusBorrow("Взята", book);
    System.out.println(
        "Взял книгу: " + reader.getName() + ". По названию: " + book.getName() + ".");
  }

  @Override
  public void removeBookFromReader() {
    // Над этим методом думаю, как сделать так чтоб проверялось в базе взятых книг есть ли там
    // такоей айди или нет, если есть тогда удаляем книгу которую указываем
    var reader = readerService.findReaderById(inputClient.inputReaderId());

    borrowDAO.deleteBorrow(inputClient.inputBookId());
  }

  @Override
  public void printAllBooksTakenByReaderId() {
    var takenBook = new TakenBook();
    takenBook = filterByReader(inputClient.inputReaderId()).get(0);
    System.out.println("Читатель :" + takenBook.getReader().getName());
    System.out.println("Взята книга: " + takenBook.getBook().getName());
  }

  @Override
  public void printCurrentReaderByBookId() {
    var takenBook = filterByBook(inputClient.inputBookId()).get(0);
    System.out.println("Книга: " + takenBook.getBook().getName());
    System.out.println("Взята :" + takenBook.getReader().getName());
  }

  public List<TakenBook> filterByBook(long bookId) {
    return borrowDAO.findAllBorrow().stream()
        .filter(filterBook -> filterBook.getBook().getId() == bookId)
        .collect(Collectors.toList());
  }

  public List<TakenBook> filterByReader(long readerId) {
    return borrowDAO.findAllBorrow().stream()
        .filter(filterReader -> filterReader.getReader().getId() == readerId)
        .collect(Collectors.toList());
  }
}
