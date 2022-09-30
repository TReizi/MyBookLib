package com.booklibrary.dao.implDaoClass;

import com.booklibrary.Menu;
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
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoErrorOutput;

public class BorrowDAOImpl implements BorrowDAO {

  private final BookService bookService;
  private final ReaderService readerService;

  public BorrowDAOImpl(BookService bookService, ReaderService readerService) {

    this.bookService = bookService;
    this.readerService = readerService;
  }

  public List<Borrow> findAll() {
    String SQL_SELECT_READERS = "select *from borrow order by id";
    try (Statement statement = getNewConnection().createStatement();
        ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS); ) {
      List<Borrow> addictionDAOList = new ArrayList<>();
      while (resultReader.next()) {
        long idBook = resultReader.getLong("idBook");
        long idReader = resultReader.getLong("idReader");
        Borrow takenBook =
            new Borrow(readerService.findReaderById(idReader), bookService.findBookById(idBook));
        addictionDAOList.add(takenBook);
      }
      return addictionDAOList;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return findAll();
    }
  }

  @Override
  public boolean delete(long deleteBook) {
    String SQL = "DELETE FROM borrow WHERE idBook = ?";
    String sqlStatus = "update books set status = ? where id= ?";
    try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(SQL);
        PreparedStatement preparedStatementStatus =
            getNewConnection().prepareStatement(sqlStatus); ) {
      preparedStatement.setLong(1, deleteBook);
      preparedStatement.executeUpdate();
      preparedStatementStatus.setString(1, "Можно брать");
      preparedStatementStatus.setLong(2, deleteBook);
      preparedStatementStatus.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return false;
    }
  }

  @Override
  public boolean statusBorrow(String status, Book bookid) {
    String sql = "update books set status = ? where id = ?";
    try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sql); ) {
      preparedStatement.setString(1, status);
      preparedStatement.setLong(2, bookid.getId());
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return false;
    }
  }

  @Override
  public boolean borrowBookToReader(Reader reader, Book book) {
    String sql = "insert into borrow(idReader,idBook) value(?,?)";
    try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sql); ) {
      preparedStatement.setLong(1, reader.getId());
      preparedStatement.setLong(2, book.getId());
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return false;
    }
  }
}
