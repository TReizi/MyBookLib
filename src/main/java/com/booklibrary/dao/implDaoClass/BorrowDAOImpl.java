package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.BorrowDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoBorrowErrorOutput;

public class BorrowDAOImpl implements BorrowDAO {

  private final BookService bookService;
  private final ReaderService readerService;

  public BorrowDAOImpl(BookService bookService, ReaderService readerService) {

    this.bookService = bookService;
    this.readerService = readerService;
  }

  @Override
  public List<Borrow> findAll() {
    String SQL_SELECT_READERS = "select *from borrow order by id";
    List<Borrow> addictionDAOList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement();
        var resultReader = statement.executeQuery(SQL_SELECT_READERS); ) {
      while (resultReader.next()) {
        long idBook = resultReader.getLong("idBook");
        long idReader = resultReader.getLong("idReader");
        Borrow takenBook =
            new Borrow(readerService.findReaderById(idReader), bookService.findBookById(idBook));
        addictionDAOList.add(takenBook);
      }
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return addictionDAOList;
  }

  @Override
  public boolean delete(long deleteBook) {
    String SQL = "DELETE FROM borrow WHERE idBook = ?";
    String sqlStatus = "update books set status = ? where id= ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL);
        var statementStatus = connection.prepareStatement(sqlStatus); ) {
      statement.setLong(1, deleteBook);
      statement.executeUpdate();
      statementStatus.setString(1, "Можно брать");
      statementStatus.setLong(2, deleteBook);
      statementStatus.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }

  @Override
  public boolean statusBorrow(String status, Book bookid) {
    String sql = "update books set status = ? where id = ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setString(1, status);
      statement.setLong(2, bookid.getId());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }

  @Override
  public boolean borrowBookToReader(Reader reader, Book book) {
    String sql = "insert into borrow(idReader,idBook) value(?,?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, reader.getId());
      statement.setLong(2, book.getId());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBorrowErrorOutput(sqlException);
    }
    return false;
  }
}
