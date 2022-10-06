package com.booklibrary.dao.implDaoClass;

import com.booklibrary.dao.Interface.ReaderDAO;
import com.booklibrary.entity.Reader;
import org.hibernate.annotations.NotFound;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.connectionSettings.ConnectionSettingsData.getNewConnection;
import static com.booklibrary.exceptionOutput.ErrorMessagePrintService.daoBookErrorOutput;
import static com.booklibrary.exceptionOutput.ErrorMessagePrintService.daoReaderErrorOutput;

public class ReaderDAOImpl implements ReaderDAO {

  @Override
  public List<Reader> findAll() {
    String SQL_SELECT_READERS = "select *from readers order by id";
    List<Reader> readerList = new ArrayList<>();
    try (var connection = getNewConnection();
        var statement = connection.createStatement();
        var resultReader = statement.executeQuery(SQL_SELECT_READERS)) {
      while (resultReader.next()) {
        int id = resultReader.getInt("id");
        String name = resultReader.getString("name");
        var reader = new Reader(id, name);
        readerList.add(reader);
      }
//      if (readerList.isEmpty()) {
//        System.out.println("Список читателей пуст. ");
//        return null;
//      }
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
    }
    return readerList;
  }

  @Override
  public boolean save(Reader reader) {
    String sql = "insert into readers(name) value(?)";
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql)) {
      statement.setString(1, reader.getName());
      statement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
      return false;
    }
  }

  @Override
  public Reader findReaderById(long readerId) {
    String sql = "SELECT * FROM readers WHERE id LIKE ?";
    Reader reader;
    try (var connection = getNewConnection();
        var statement = connection.prepareStatement(sql); ) {
      statement.setLong(1, readerId);
      ResultSet resultSet = statement.executeQuery();
      while (resultSet.next()) {
        reader = searchReader(resultSet);
        return reader;
      }
    } catch (SQLException sqlException) {
      daoBookErrorOutput(sqlException);
    }
    return null;
  }
  // по сути метод можно назвать определятор)
  @Override
  public Reader searchReader(ResultSet resultSet) {
    var reader = new Reader();
    try {
      long id = resultSet.getLong("id");
      String name = resultSet.getString("name");
      reader.setId(id);
      reader.setName(name);
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
    }
    return reader;
  }
}
