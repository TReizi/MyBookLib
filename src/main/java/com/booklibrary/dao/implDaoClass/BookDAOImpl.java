package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.BookDAO;
import com.booklibrary.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoErrorOutput;

public class BookDAOImpl implements BookDAO {

  @Override
  public List<Book> findAll() {
    String SQL_SELECT_BOOKS = "select *from books order by id";
    try (Statement statement = getNewConnection().createStatement();
        ResultSet result = statement.executeQuery(SQL_SELECT_BOOKS); ) {
      List<Book> bookList = new ArrayList<>();
      while (result.next()) {
        int id = result.getInt("id");
        String name = result.getString("name");
        String author = result.getString("author");
        String status = result.getString("Status");
        var book = new Book(id, name, author, status);
        bookList.add(book);
      }
      return bookList;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return findAll();
    }
  }

  @Override
  public boolean save(Book book) {
    String sql = "insert into books(name,author, status) value(?,?,'Книга не взята')";
    try (PreparedStatement preparedStatement = getNewConnection().prepareStatement(sql); ) {
      preparedStatement.setString(1, book.getName());
      preparedStatement.setString(2, book.getAuthor());
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoErrorOutput();
      return false;
    }
  }
}
