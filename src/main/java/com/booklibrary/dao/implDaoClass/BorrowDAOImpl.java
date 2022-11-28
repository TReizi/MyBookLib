package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.Interface.BorrowDAO;
import com.booklibrary.entity.Book;
import com.booklibrary.entity.Borrow;
import com.booklibrary.entity.Reader;
import com.booklibrary.dataValidation.exceptionOutput.ExceptionDAOMetods;
import com.sun.istack.NotNull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;

public class BorrowDAOImpl implements BorrowDAO {

  @Override
  public List<Borrow> findAll() {
    String SQL_SELECT_READERS =
        "SELECT \n"
            + "    b.id as book_id,\n"
            + "    b.author as book_author,\n"
            + "    b.name as book_name,\n"
            + "    r.id as reader_id,\n"
            + "    r.name as reader_name\n"
            + "FROM borrow \n"
            + "    JOIN reader r on borrow.reader_id = r.id\n"
            + "    JOIN book b on borrow.book_id = b.id;";
    List<Borrow> borrowList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL_SELECT_READERS);
        var resultSet = statement.executeQuery()) {
      while (resultSet.next()) {
        Borrow borrow = mapToLibrary(resultSet);
        borrowList.add(borrow);
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return borrowList;
  }

  @Override
  public boolean delete(long deleteBook, long idReader) {
    String SQL = "DELETE FROM borrow WHERE book_id = ? AND IdReader = ?";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(SQL)) {
      statement.setLong(1, deleteBook);
      statement.setLong(2, idReader);
      statement.executeUpdate();
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public boolean borrowBookToReader(long readerId, long bookId) {
    String sql = "INSERT INTO borrow(book_id,reader_id) values(?,?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, bookId);
      statement.setLong(2, readerId);
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public List<Borrow> filterByReader(long readerId) {
    String sql =
        "SELECT book.id, book.name, book.author \n"
            + " FROM borrow \n"
            + " JOIN book \n"
            + " ON borrow.book_id = book.id \n"
            + " WHERE borrow.reader_id = (?) ";
    var borrow = new Borrow();
    List<Borrow> readerList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Book book = mapToBook(resultSet);
        borrow = new Borrow(book);
        readerList.add(borrow);
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return readerList;
  }

  @Override
  public List<Borrow> filterByBook(long bookId) {
    String sql =
        "SELECT reader.id, reader.name \n"
            + " FROM borrow \n"
            + " JOIN reader \n"
            + " ON borrow.reader_id = reader.id \n"
            + " WHERE borrow.book_id = (?)";
    List<Borrow> bookList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setLong(1, bookId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        Reader reader = mapToReader(resultSet);
        Borrow borrow = new Borrow(reader);
        bookList.add(borrow);
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return bookList;
  }

  public Book mapToBook(ResultSet resultSet) {
    return getBook(resultSet);
  }

  public Reader mapToReader(ResultSet resultSet) {
    return getReader(resultSet);
  }

  @NotNull
  static Book getBook(ResultSet resultSet) {
    var book = new Book();
    try {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      String author = resultSet.getString("author");
      book.setId(id);
      book.setName(name);
      book.setAuthor(author);
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return book;
  }

  @NotNull
  static Reader getReader(ResultSet resultSet) {
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

  public Borrow mapToLibrary(ResultSet resultSet) {
    var book = new Book();
    var reader = new Reader();
    var borrow = new Borrow();
    try {
      long book_id = resultSet.getLong("book_id");
      String book_name = resultSet.getString("book_name");
      String book_author = resultSet.getString("book_author");
      book.setId(book_id);
      book.setName(book_name);
      book.setAuthor(book_author);
      long reader_id = resultSet.getLong("reader_id");
      String reader_name = resultSet.getString("reader_name");
      reader.setId(reader_id);
      reader.setName(reader_name);
      borrow.setReader(reader);
      borrow.setBook(book);

    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return borrow;
  }
}
