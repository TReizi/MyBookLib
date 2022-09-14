package com.booklibrary.dao;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Reader;
import com.booklibrary.entity.TakenBook;
import com.booklibrary.service.BookServiceImpl;
import com.booklibrary.service.ReaderServiceImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddictionDAOImpl implements AddictionDAO {

  private final ConnectionSettingsData connectionSettingsData;
  private final BookServiceImpl bookService;
  private final ReaderServiceImpl readerService;

  public AddictionDAOImpl(
      ConnectionSettingsData connectionSettingsData,
      BookServiceImpl bookService,
      ReaderServiceImpl readerService) {
    this.connectionSettingsData = connectionSettingsData;
    this.bookService = bookService;
    this.readerService = readerService;
  }

  @Override
  public List<TakenBook> findAllAddiction() throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    Statement statement = connection.createStatement();
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
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    String SQL = "DELETE FROM addiction WHERE idBook = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(SQL);
    preparedStatement.setLong(1, deleteBook);
    String sqlStatus = "update books set status = ? where id = ?";
    PreparedStatement preparedStatementStatus = connection.prepareStatement(sqlStatus);
    preparedStatementStatus.setString(1, "Можно брать");
    preparedStatementStatus.setLong(2, deleteBook);
    preparedStatementStatus.executeUpdate();
    connection.close();
  }

  @Override
  public void statusСhange(String status, Book bookid) throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    String sql = "update books set status = ? where id = ?";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, status);
    preparedStatement.setLong(2, bookid.getId());
    preparedStatement.executeUpdate();

    connection.close();
  }

  @Override
  public void addABookReader(Reader reader, Book book) throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    String sql = "insert into addiction(idReader,idBook) value(?,?)";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setLong(1, reader.getId());
    preparedStatement.setLong(2, book.getId());

    preparedStatement.executeUpdate();
    connection.close();
  }
}
