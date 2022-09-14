package com.booklibrary.dao;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BookDAOImpl implements BookDAO {

  private final ConnectionSettingsData connectionSettingsData;

  public BookDAOImpl(ConnectionSettingsData connectionSettingsData) {
    this.connectionSettingsData = connectionSettingsData;
  }

  @Override
  public List<Book> findAllBook() throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    Statement statement = connection.createStatement();
    String SQL_SELECT_BOOKS = "select *from books order by id";
    ResultSet result = statement.executeQuery(SQL_SELECT_BOOKS);
    List<Book> bookList = new ArrayList<>();
    while (result.next()) {
      int id = result.getInt("id");
      String name = result.getString("name");
      String author = result.getString("author");
      String status = result.getString("Status");
      var book = new Book(id, name, author, status);
      bookList.add(book);
    }
    connection.close();
    return bookList;
  }

  @Override
  public void addBookDatabase(Book book) throws SQLException {
    Connection connection =
        DriverManager.getConnection(
            connectionSettingsData.DB_URL,
            connectionSettingsData.DB_USERNAME,
            connectionSettingsData.DB_PASSWORD);
    String sql = "insert into books(name,author, status) value(?,?,'Книга не взята')";
    PreparedStatement preparedStatement = connection.prepareStatement(sql);
    preparedStatement.setString(1, book.getName());
    preparedStatement.setString(2, book.getAuthor());
    preparedStatement.executeUpdate();
    connection.close();
  }
}
