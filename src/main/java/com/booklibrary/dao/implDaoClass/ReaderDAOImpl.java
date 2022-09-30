package com.booklibrary.dao.implDaoClass;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.entity.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.booklibrary.exceptionOutput.errorOutputRepository.daoReaderErrorOutput;

public class ReaderDAOImpl implements ReaderDAO {

  private final ConnectionSettingsData connectionSettingsData;

  public ReaderDAOImpl(ConnectionSettingsData connectionSettingsData) {
    this.connectionSettingsData = connectionSettingsData;
  }

  @Override
  public List<Reader> findAll() {
    String SQL_SELECT_READERS = "select *from readers order by id";
    List<Reader> readerList = new ArrayList<>();
    try (Statement statement = connectionSettingsData.getNewConnection().createStatement();
        ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS); ) {
      while (resultReader.next()) {
        int id = resultReader.getInt("id");
        String name = resultReader.getString("name");
        var reader = new Reader(id, name);
        readerList.add(reader);
      }
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
    }
    return readerList;
  }

  @Override
  public boolean save(Reader reader) {
    String sql = "insert into readers(name) value(?)";
    try (PreparedStatement preparedStatement =
        connectionSettingsData.getNewConnection().prepareStatement(sql); ) {
      preparedStatement.setString(1, reader.getName());
      preparedStatement.executeUpdate();
      return true;
    } catch (SQLException sqlException) {
      daoReaderErrorOutput(sqlException);
      return false;
    }
  }
}
