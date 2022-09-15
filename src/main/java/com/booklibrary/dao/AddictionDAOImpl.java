package com.booklibrary.dao;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;
import com.booklibrary.service.BookService;
import com.booklibrary.service.ReaderService;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddictionDAOImpl implements AddictionDAO {

  private final ConnectionSettingsData connectionSettingsData;
  private final BookService bookService;
  private final ReaderService readerService;


  public AddictionDAOImpl(
      ConnectionSettingsData connectionSettingsData,
      BookService bookService,
      ReaderService readerService) {
    this.connectionSettingsData = connectionSettingsData;
    this.bookService = bookService;
    this.readerService = readerService;
  }

  @Override
  public List<TakenBook> findAllAddiction() throws SQLException {
    connectionSettingsData.newConnecting();
    Statement statement = connectionSettingsData.newConnecting().createStatement();
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
  public void deleteAddication(long deleteBook) throws SQLException {

    String SQL = "DELETE FROM addiction WHERE idBook = ?";
    PreparedStatement preparedStatement = connectionSettingsData.newConnecting().prepareStatement(SQL);
    preparedStatement.setLong(1, deleteBook);
    String sqlStatus = "update books set status = ? where id = ?";
    PreparedStatement preparedStatementStatus = connectionSettingsData.newConnecting().prepareStatement(sqlStatus);
    preparedStatementStatus.setString(1, "Можно брать");
    preparedStatementStatus.setLong(2, deleteBook);
    preparedStatementStatus.executeUpdate();
    connectionSettingsData.newConnecting().close();
  }

  @Override
  public void statusСhange(String status, Book bookid) throws SQLException {
    String sql = "update books set status = ? where id = ?";
    PreparedStatement preparedStatement = connectionSettingsData.newConnecting().prepareStatement(sql);
    preparedStatement.setString(1, status);
    preparedStatement.setLong(2, bookid.getId());
    preparedStatement.executeUpdate();
    connectionSettingsData.newConnecting().close();
  }

  @Override
  public void addABookReader(Reader reader, Book book) throws SQLException {
    String sql = "insert into addiction(idReader,idBook) value(?,?)";
    PreparedStatement preparedStatement = connectionSettingsData.newConnecting().prepareStatement(sql);
    preparedStatement.setLong(1, reader.getId());
    preparedStatement.setLong(2, book.getId());
    preparedStatement.executeUpdate();
    connectionSettingsData.newConnecting().close();
  }
}
