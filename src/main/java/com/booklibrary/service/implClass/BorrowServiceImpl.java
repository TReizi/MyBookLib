package com.booklibrary.service.implClass;

import com.booklibrary.entity.Borrow;
import com.booklibrary.ui.InputClient;
import com.booklibrary.dao.BorrowDAO;
import com.booklibrary.dao.implDaoClass.BorrowDAOImpl;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;
import com.booklibrary.service.BorrowService;

import java.util.List;
import java.util.stream.Collectors;

public class BorrowServiceImpl implements BorrowService {

  private final BookService bookService = new BookServiceImpl();
  private final ReaderService readerService = new ReaderServiceImpl();
  private final InputClient inputClient = new InputClient();
  private final BorrowDAO borrowDAO = new BorrowDAOImpl(bookService, readerService);

  @Override
  public void issueBook() {
    var reader = readerService.findReaderById(inputClient.inputReaderId());
    var book = bookService.findBookById(inputClient.inputBookId());
    borrowDAO.borrowBookToReader(reader, book);
    borrowDAO.statusBorrow("Взята", book);
    System.out.println(
        "Взял книгу: " + reader.getName() + ". По названию: " + book.getName() + ".");
  }

  @Override
  public void removeBookFromReader() {
    // Над этим методом думаю, как сделать так чтоб проверялось в базе взятых книг есть ли там
    // такоей айди или нет, если есть тогда удаляем книгу которую указываем
    var reader = readerService.findReaderById(inputClient.inputReaderId());

    borrowDAO.delete(inputClient.inputBookId());
  }

  @Override
  public void printAllBooksTakenByReaderId() {
    var takenBook = new Borrow();
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

  public List<Borrow> filterByBook(long bookId) {
    return borrowDAO.findAll().stream()
        .filter(filterBook -> filterBook.getBook().getId() == bookId)
        .collect(Collectors.toList());
  }

  public List<Borrow> filterByReader(long readerId) {
    return borrowDAO.findAll().stream()
        .filter(filterReader -> filterReader.getReader().getId() == readerId)
        .collect(Collectors.toList());
  }
}
