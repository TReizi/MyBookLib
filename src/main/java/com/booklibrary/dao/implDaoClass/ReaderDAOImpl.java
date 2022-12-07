package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.entity.Reader;
import com.booklibrary.exceptionOutput.ExceptionDAOMetods;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.dao.implDaoClass.BorrowDAOImpl.getReader;

public class ReaderDAOImpl implements ReaderDAO {

  @Override
  public List<Reader> findAll() {
    String SQL_SELECT_READERS = "select *from reader order by id";
    List<Reader> readerList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement(); ) {
      var resultReader = statement.executeQuery(SQL_SELECT_READERS);
      while (resultReader.next()) {
        readerList.add(mapToReader(resultReader));
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return readerList;
  }

  @Override
  public boolean save(Reader reader) {
    String sql = "insert into reader(name) values(?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, reader.getName());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
  }

  @Override
  public Optional<Reader> findReaderById(long readerId) {
    String sql = "SELECT * FROM reader WHERE id=?";
    try (var connection = getNewConnection()) {
      var statement = connection.prepareStatement(sql);
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        return Optional.of(mapToReader(resultSet));
      }
    } catch (SQLException sqlException) {
      throw new ExceptionDAOMetods(sqlException);
    }
    return Optional.empty();
  }

  public Reader mapToReader(ResultSet resultSet) {
    return getReader(resultSet);
  }
}
