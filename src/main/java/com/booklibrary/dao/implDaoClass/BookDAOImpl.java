package com.booklibrary.dao.implDaoClass;

import com.booklibrary.Menu;
import com.booklibrary.dao.BookDAO;
import com.booklibrary.entity.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnecting;
import static com.booklibrary.exceptionOutput.errorOutputRepository.daoErrorOutput;
import static com.booklibrary.exceptionOutput.errorOutputRepository.menuOutput;

public class BookDAOImpl implements BookDAO {
  private int retryCountFindAllBook = 0;
  private int retryCountAddBookDatabase = 0;

  @Override
  public List<Book> findAll() {

    try {
      Statement statement = getNewConnecting().createStatement();
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
      statement.close();
      return bookList;
    } catch (SQLException sqlException) {
      if (retryCountFindAllBook == 3) {
        retryCountFindAllBook++;
        menuOutput();
        retryCountFindAllBook = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return findAll();
    }
  }

  @Override
  public boolean save(Book book) {
    try {
      String sql = "insert into books(name,author, status) value(?,?,'Книга не взята')";
      PreparedStatement preparedStatement = getNewConnecting().prepareStatement(sql);
      preparedStatement.setString(1, book.getName());
      preparedStatement.setString(2, book.getAuthor());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException sqlException) {
      if (retryCountAddBookDatabase != 3) {
        retryCountAddBookDatabase++;
        if (retryCountAddBookDatabase == 3) {
          menuOutput();
          retryCountAddBookDatabase = 0;
          new Menu().start();
        }
      }
      daoErrorOutput();
      return false;
    }
    return true;
  }
}
