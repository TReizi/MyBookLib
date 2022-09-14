package com.booklibrary.dao;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.entity.Reader;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReaderDAOImpl implements ReaderDAO{


    private final ConnectionSettingsData connectionSettingsData;

    public ReaderDAOImpl(ConnectionSettingsData connectionSettingsData) {
        this.connectionSettingsData = connectionSettingsData;
    }

    @Override
    public List<Reader> findAllReader() throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        connectionSettingsData.DB_URL,
                        connectionSettingsData.DB_USERNAME,
                        connectionSettingsData.DB_PASSWORD);
        Statement statement = connection.createStatement();
        String SQL_SELECT_READERS = "select *from readers order by id";
        ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS);
        List<Reader> readerList = new ArrayList<>();
        while (resultReader.next()) {
            int id = resultReader.getInt("id");
            String name = resultReader.getString("name");
            var  reader = new Reader(id,name);
            readerList.add(reader);
        }
        connection.close();
        return readerList;
    }

    @Override
    public void addReaderDatabase(Reader reader) throws SQLException {
        Connection connection =
                DriverManager.getConnection(
                        connectionSettingsData.DB_URL,
                        connectionSettingsData.DB_USERNAME,
                        connectionSettingsData.DB_PASSWORD);
        String sql = "insert into readers(name) value(?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1, reader.getName());
        preparedStatement.executeUpdate();
        connection.close();
    }
}
