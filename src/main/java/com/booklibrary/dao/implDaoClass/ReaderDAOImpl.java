package com.booklibrary.dao.implDaoClass;

import com.booklibrary.Menu;
import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.entity.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.exceptionOutput.errorOutputRepository.daoErrorOutput;
import static com.booklibrary.exceptionOutput.errorOutputRepository.menuOutput;

public class ReaderDAOImpl implements ReaderDAO {

  private final ConnectionSettingsData connectionSettingsData;
  private int retryCountFindAllReader = 0;
  private int retryCountAddReaderDatabase = 0;

  public ReaderDAOImpl(ConnectionSettingsData connectionSettingsData) {
    this.connectionSettingsData = connectionSettingsData;
  }

  @Override
  public List<Reader> findAll() {
    try {
      Statement statement = connectionSettingsData.getNewConnecting().createStatement();
      String SQL_SELECT_READERS = "select *from readers order by id";
      ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS);
      List<Reader> readerList = new ArrayList<>();
      while (resultReader.next()) {
        int id = resultReader.getInt("id");
        String name = resultReader.getString("name");
        var reader = new Reader(id, name);
        readerList.add(reader);
      }
      statement.close();

      return readerList;
    } catch (SQLException sqlException) {
      if (retryCountFindAllReader != 3) {
        retryCountFindAllReader++;
        if (retryCountFindAllReader == 3) {
          menuOutput();
          retryCountFindAllReader = 0;
          new Menu().start();
        }
      }
      daoErrorOutput();
      return findAll();
    }
  }

  @Override
  public boolean save(Reader reader) {
    try {
      String sql = "insert into readers(name) value(?)";
      PreparedStatement preparedStatement =
          connectionSettingsData.getNewConnecting().prepareStatement(sql);
      preparedStatement.setString(1, reader.getName());
      preparedStatement.executeUpdate();
      preparedStatement.close();
    } catch (SQLException sqlException) {
      if (retryCountAddReaderDatabase != 3) {
        retryCountAddReaderDatabase++;
        if (retryCountAddReaderDatabase == 3) {
          menuOutput();
          retryCountAddReaderDatabase = 0;
          new Menu().start();
        }
      }
      daoErrorOutput();
      return false;
    }
    return true;
  }
}
