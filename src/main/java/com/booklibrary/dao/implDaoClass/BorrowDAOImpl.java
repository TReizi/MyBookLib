package com.booklibrary.dao.implDaoClass;

import com.booklibrary.connectionSettings.StatusBook;
import com.booklibrary.dao.Interface.BookDAO;
import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;
import com.booklibrary.exceptionOutput.ExceptionDAOMetods;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;

public class BorrowDAOImpl implements BorrowDAO {
  private final ReaderDAO readerDAO = new ReaderDAOImpl();
  private final BookDAO bookDAO = new BookDAOImpl();

  @Override
  public Map<Reader, List<Book>> findAll() {
    String SQL_SELECT_READERS =
        "SELECT readers.id, readers.name, books.id AS book_id, books.name, books.author, books.status \n"+
           "FROM readers, books JOIN borrow \n"+
            "ON borrow.idBook = books.id WHERE readers.id = borrow.idReader";
    Map<Reader, List<Book>> readerListMap = new HashMap<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL_SELECT_READERS);
        var resultSet = statement.executeQuery(SQL_SELECT_READERS)) {
      while (resultSet.next()) {
        Reader reader = mapToReader(resultSet);
        Book book = mapToBook(resultSet);
        if (readerListMap.containsKey(reader)) {
          readerListMap.get(reader).add(book);
        } else {
          List<Book> bookList = new ArrayList<>();
          bookList.add(book);
          readerListMap.put(reader, bookList);
        }
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return readerListMap;
  }

  @Override
  public boolean delete(long deleteBook) {
    String SQL = "DELETE FROM borrow WHERE idBook = ?";
    String sqlStatus = "update books set status = ? where id= ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL);
        var statementStatus = connection.prepareStatement(sqlStatus)) {
      statement.setLong(1, deleteBook);
      statement.executeUpdate();
      statementStatus.setString(1, StatusBook.available.getStatusBook());
      statementStatus.setLong(2, deleteBook);
      statementStatus.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public boolean statusBorrow(String status, long bookId) {
    String sql = "update books set status = ? where id = ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, status);
      statement.setLong(2, bookId);
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public boolean borrowBookToReader(long readerId, long bookId) {
    String sql = "insert into borrow(idReader,idBook) value(?,?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, readerId);
      statement.setLong(2, bookId);
      statusBorrow(StatusBook.taken.getStatusBook(), bookId);
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public List<Borrow> filterByReader(long readerId) {
    String sql = "SELECT * FROM borrow WHERE idReader =  ?";
    var borrow = new Borrow();
    Reader reader;
    Book book;
    List<Borrow> readerList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        reader = searchDAOReader(resultSet);
        book = searchDAOBook(resultSet);
        borrow.setReader(reader);
        borrow.setBook(book);
        readerList.add(borrow);
      }
      resultSet.close();
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return readerList;
  }

  @Override
  public List<Borrow> filterByBook(long bookId) {
    String sql = "SELECT * FROM borrow WHERE idBook = ?";
    var borrow = new Borrow();
    Reader reader;
    Book book;
    List<Borrow> bookList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, bookId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        reader = searchDAOReader(resultSet);
        book = searchDAOBook(resultSet);
        borrow.setReader(reader);
        borrow.setBook(book);
        bookList.add(borrow);
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return bookList;
  }

  public Book searchDAOBook(ResultSet resultSet) {
    var book = new Book();
    try {
      long idBook = resultSet.getLong("idBook");
      book.setId(idBook);
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return book;
  }

  @Override
  public Reader searchDAOReader(ResultSet resultSet) {
    var reader = new Reader();
    try {
      long idReader = resultSet.getLong("idReader");
      reader.setId(idReader);
      bookDAO.findBookById(reader.getId());
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return reader;
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

  public Reader mapToReader(ResultSet resultSet) {
    var reader = new Reader();
    try {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      reader.setId(id);
      reader.setName(name);
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return reader;
  }
}
