package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.BookDAO;
import com.booklibrary.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoBookErrorOutput;

public class BookDAOImpl implements BookDAO {

  @Override
  public List<Book> findAll() {
    String SQL_SELECT_BOOKS = "select *from books order by id";
    List<Book> bookList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement();
        var result = statement.executeQuery(SQL_SELECT_BOOKS); ) {

      while (result.next()) {
        int id = result.getInt("id");
        String name = result.getString("name");
        String author = result.getString("author");
        String status = result.getString("Status");
        var book = new Book(id, name, author, status);
        bookList.add(book);
      }
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return bookList;
  }

  @Override
  public boolean save(Book book) {
    String sql = "insert into books(name,author, status) value(?,?,'Книга не взята')";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, book.getName());
      statement.setString(2, book.getAuthor());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return false;
  }
}
