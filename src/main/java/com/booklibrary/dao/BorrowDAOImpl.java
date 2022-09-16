package com.booklibrary.dao;


import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.newConnecting;

public class BorrowDAOImpl implements BorrowDao {

  private final BookService bookService;
  private final ReaderService readerService;

  public BorrowDAOImpl(BookService bookService, ReaderService readerService) {

    this.bookService = bookService;
    this.readerService = readerService;
  }

  public List<TakenBook> findAllBorrow() throws SQLException {
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
    return addictionDAOList;
  }

  @Override
  public void deleteBorrow(long deleteBook) throws SQLException {

    String SQL = "DELETE FROM addiction WHERE idBook = ?";
    PreparedStatement preparedStatement = newConnecting().prepareStatement(SQL);
    preparedStatement.setLong(1, deleteBook);
    preparedStatement.executeUpdate();
    String sqlStatus = "update books set status = ? where id= ?";
    PreparedStatement preparedStatementStatus = newConnecting().prepareStatement(sqlStatus);
    preparedStatementStatus.setString(1, "Можно брать");
    preparedStatementStatus.setLong(2, deleteBook);
    preparedStatementStatus.executeUpdate();
    newConnecting().close();
  }

  @Override
  public void statusBorrow(String status, Book bookid) throws SQLException {
    String sql = "update books set status = ? where id = ?";
    PreparedStatement preparedStatement = newConnecting().prepareStatement(sql);
    preparedStatement.setString(1, status);
    preparedStatement.setLong(2, bookid.getId());
    preparedStatement.executeUpdate();
    newConnecting().close();
  }

  @Override
  public void addABookReader(Reader reader, Book book) throws SQLException {
    String sql = "insert into addiction(idReader,idBook) value(?,?)";
    PreparedStatement preparedStatement = newConnecting().prepareStatement(sql);
    preparedStatement.setLong(1, reader.getId());
    preparedStatement.setLong(2, book.getId());
    preparedStatement.executeUpdate();
    newConnecting().close();
  }
}
