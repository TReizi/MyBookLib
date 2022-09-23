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
  public List<Reader> findAllReader() {
    try {
      Statement statement = connectionSettingsData.newConnecting().createStatement();
      String SQL_SELECT_READERS = "select *from readers order by id";
      ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS);
      List<Reader> readerList = new ArrayList<>();
      while (resultReader.next()) {
        int id = resultReader.getInt("id");
        String name = resultReader.getString("name");
        var reader = new Reader(id, name);
        readerList.add(reader);
      }
      connectionSettingsData.newConnecting().close();
      retryCountFindAllReader++;
      return readerList;
    } catch (SQLException sqlException) {
      if (retryCountFindAllReader == 3) {
        menuOutput();
        retryCountFindAllReader = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return findAllReader();
    }
  }

  @Override
  public boolean addReaderDatabase(Reader reader) {
    try {
      String sql = "insert into readers(name) value(?)";
      PreparedStatement preparedStatement =
          connectionSettingsData.newConnecting().prepareStatement(sql);
      preparedStatement.setString(1, reader.getName());
      preparedStatement.executeUpdate();
      retryCountAddReaderDatabase++;
      connectionSettingsData.newConnecting().close();
    } catch (SQLException sqlException) {
      if (retryCountAddReaderDatabase == 3) {
        menuOutput();
        retryCountAddReaderDatabase = 0;
        new Menu().start();
      }
      daoErrorOutput();
      return false;
    }
    return true;
  }
}
