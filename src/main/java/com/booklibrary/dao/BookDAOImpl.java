package com.booklibrary.dao;

import com.booklibrary.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.newConnecting;

public class BookDAOImpl implements BookDAO {

  @Override
  public List<Book> findAllBook() throws SQLException {
    Statement statement = newConnecting().createStatement();
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
    newConnecting().close();
    return bookList;
  }

  @Override
  public void addBookDatabase(Book book) throws SQLException {
    String sql = "insert into books(name,author, status) value(?,?,'Книга не взята')";
    PreparedStatement preparedStatement = newConnecting().prepareStatement(sql);
    preparedStatement.setString(1, book.getName());
    preparedStatement.setString(2, book.getAuthor());
    preparedStatement.executeUpdate();
    newConnecting().close();
  }
}
