package com.booklibrary.dao.implDaoClass;

import com.booklibrary.Menu;
import com.booklibrary.dao.BorrowDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.newConnecting;
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoErrorOutput;
import static com.booklibrary.exceptionOutput.errorOutputRepository.menuOutput;

public class BorrowDAOImpl implements BorrowDAO {

  private final BookService bookService;
  private final ReaderService readerService;

  private int retryCountFindAllBorrow = 0;
  private int retryCountDeleteBorrow = 0;
  private int retryCountStatusBorrow = 0;
  private int retryCountAddABookReader = 0;

  public BorrowDAOImpl(BookService bookService, ReaderService readerService) {

    this.bookService = bookService;
    this.readerService = readerService;
  }

  public List<TakenBook> findAllBorrow() {
    try {
      Statement statement = newConnecting().createStatement();
      String SQL_SELECT_READERS = "select *from addiction order by id";
      ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS);
      List<TakenBook> addictionDAOList = new ArrayList<>();
      while (resultReader.next()) {
        long idBook = resultReader.getLong("idBook");
        long idReader = resultReader.getLong("idReader");
        TakenBook takenBook =
            new TakenBook(readerService.findReaderById(idReader), bookService.findBookById(idBook));
        addictionDAOList.add(takenBook);
      }
      retryCountFindAllBorrow++;
      return addictionDAOList;
    } catch (SQLException sqlException) {
      if (retryCountFindAllBorrow == 3) {
        menuOutput();
        retryCountFindAllBorrow = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return findAllBorrow();
    }
  }

  @Override
  public boolean deleteBorrow(long deleteBook) {
    try {
      String SQL = "DELETE FROM addiction WHERE idBook = ?";
      PreparedStatement preparedStatement = newConnecting().prepareStatement(SQL);
      preparedStatement.setLong(1, deleteBook);
      preparedStatement.executeUpdate();
      String sqlStatus = "update books set status = ? where id= ?";
      PreparedStatement preparedStatementStatus = newConnecting().prepareStatement(sqlStatus);
      preparedStatementStatus.setString(1, "Можно брать");
      preparedStatementStatus.setLong(2, deleteBook);
      preparedStatementStatus.executeUpdate();
      retryCountDeleteBorrow++;
      newConnecting().close();
    } catch (SQLException sqlException) {
      if (retryCountDeleteBorrow == 3) {
        menuOutput();
        retryCountDeleteBorrow = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return false;
    }
    return true;
  }

  @Override
  public boolean statusBorrow(String status, Book bookid) {
    try {
      String sql = "update books set status = ? where id = ?";
      PreparedStatement preparedStatement = newConnecting().prepareStatement(sql);
      preparedStatement.setString(1, status);
      preparedStatement.setLong(2, bookid.getId());
      preparedStatement.executeUpdate();
      retryCountStatusBorrow++;
      newConnecting().close();
    } catch (SQLException sqlException) {
      if (retryCountStatusBorrow == 3) {
        menuOutput();
        retryCountStatusBorrow = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return false;
    }
    return true;
  }

  @Override
  public boolean addABookReader(Reader reader, Book book) {
    try {
      String sql = "insert into addiction(idReader,idBook) value(?,?)";
      PreparedStatement preparedStatement = newConnecting().prepareStatement(sql);
      preparedStatement.setLong(1, reader.getId());
      preparedStatement.setLong(2, book.getId());
      preparedStatement.executeUpdate();
      retryCountAddABookReader++;
      newConnecting().close();
    } catch (SQLException sqlException) {
      if (retryCountAddABookReader == 3) {
        menuOutput();
        retryCountAddABookReader = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return false;
    }
  return true;
  }
}
