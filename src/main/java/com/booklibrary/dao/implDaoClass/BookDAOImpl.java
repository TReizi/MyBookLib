package com.booklibrary.dao.implDaoClass;

import com.booklibrary.connectionSettings.StatusBook;
import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.exceptionOutput.ExceptionDAOMetods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.ErrorMessagePrintService.daoBookErrorOutput;

public class BookDAOImpl implements BookDAO {

  @Override
  public List<Book> findAll() {
    String SQL_SELECT_BOOKS = "select *from books order by id";
    List<Book> bookList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement();
        ) {
      var result = statement.executeQuery(SQL_SELECT_BOOKS);
      while (result.next()) {
      bookList.add(mapToBook(result));
      }
      result.close();
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return bookList;
  }

  @Override
  public boolean save(Book book) {
    String sql = "insert into books(name,author, status) values(?,?,?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, book.getName());
      statement.setString(2, book.getAuthor());
      statement.setString(3, StatusBook.available.getStatusBook());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public Optional <Book> findBookById(Long readerId) {
    String sql = "SELECT * FROM books WHERE id = ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
         return Optional.of(mapToBook(resultSet));
      }
      resultSet.close();
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return Optional.empty();
  }

  public Book mapToBook(ResultSet resultSet) {
    var book = new Book();
    try {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      String author = resultSet.getString("author");
      String status = resultSet.getString("status");
      book.setId(id);
      book.setName(name);
      book.setAuthor(author);
      book.setStatus(status);
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return book;
  }
}
