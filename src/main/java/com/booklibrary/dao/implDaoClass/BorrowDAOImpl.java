package com.booklibrary.dao.implDaoClass;

import com.booklibrary.connectionSettings.StatusBook;
import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.ErrorMessagePrintService.*;

public class BorrowDAOImpl implements BorrowDAO {
  private final ReaderDAO readerDAO = new ReaderDAOImpl();
  private final BookDAO bookDAO = new BookDAOImpl();

  @Override
  public List<Borrow> findAll() {
    String SQL_SELECT_READERS = "select *from borrow order by id";
    List<Borrow> borrowDAOList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement();
        var resultReader = statement.executeQuery(SQL_SELECT_READERS)) {
      while (resultReader.next()) {
        long idBook = resultReader.getLong("idBook");
        long idReader = resultReader.getLong("idReader");
        Borrow takenBook =
            new Borrow(
                new ReaderDAOImpl().findReaderById(idReader),
                new BookDAOImpl().findBookById(idBook));
        borrowDAOList.add(takenBook);
      }
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return borrowDAOList;
  }

  @Override
  public boolean delete(long deleteBook) {
    String SQL = "DELETE FROM borrow WHERE idBook = ?";
    String sqlStatus = "update books set status = ? where id= ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL);
        var statementStatus = connection.prepareStatement(sqlStatus)) {
      statement.setLong(1, deleteBook);
      statement.executeUpdate();
      statementStatus.setString(1, StatusBook.available.getStatusBook());
      statementStatus.setLong(2, deleteBook);
      statementStatus.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }

  @Override
  public boolean statusBorrow(String status, long bookId) {
    String sql = "update books set status = ? where id = ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, status);
      statement.setLong(2, bookId);
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }

  @Override
  public boolean borrowBookToReader(long readerId, long bookId) {
    String sql = "insert into borrow(idReader,idBook) value(?,?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, readerId);
      statement.setLong(2, bookId);
      statusBorrow(StatusBook.taken.getStatusBook(), bookId);
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }

  @Override
  public List<Borrow> filterByReader(long readerId) {
    String sql = "SELECT * FROM borrow WHERE idReader LIKE ?";
    var borrow = new Borrow();
    Reader reader;
    Book book;
    List<Borrow> readerList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        reader = searchDAOReader(resultSet);
        book = searchDAOBook(resultSet);
        borrow.setReader(reader);
        borrow.setBook(book);
        readerList.add(borrow);
      }
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return readerList;
  }

  @Override
  public List<Borrow> filterByBook(long bookId) {
    String sql = "SELECT * FROM borrow WHERE idBook LIKE ?";
    var borrow = new Borrow();
    Reader reader;
    Book book;
    List<Borrow> bookList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, bookId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        reader = searchDAOReader(resultSet);
        book = searchDAOBook(resultSet);
        borrow.setReader(reader);
        borrow.setBook(book);
        bookList.add(borrow);
      }
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return bookList;
  }

  public Book searchDAOBook(ResultSet resultSet) {
    var book = new Book();
    try {
      long idBook = resultSet.getLong("idBook");
      book.setId(idBook);
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return book;
  }

  @Override
  public Reader searchDAOReader(ResultSet resultSet) {
    var reader = new Reader();
    try {
      long idReader = resultSet.getLong("idReader");
      reader.setId(idReader);
      bookDAO.findBookById(reader.getId());
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
    }
    return reader;
  }
}
