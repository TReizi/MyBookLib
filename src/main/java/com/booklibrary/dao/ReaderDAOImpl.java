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
        Statement statement = connectionSettingsData.newConnecting().createStatement();
        String SQL_SELECT_READERS = "select *from readers order by id";
        ResultSet resultReader = statement.executeQuery(SQL_SELECT_READERS);
        List<Reader> readerList = new ArrayList<>();
        while (resultReader.next()) {
            int id = resultReader.getInt("id");
            String name = resultReader.getString("name");
            var  reader = new Reader(id,name);
            readerList.add(reader);
        }
        connectionSettingsData.newConnecting().close();
        return readerList;
    }

    @Override
    public void addReaderDatabase(Reader reader) throws SQLException {
        String sql = "insert into readers(name) value(?)";
        PreparedStatement preparedStatement = connectionSettingsData.newConnecting().prepareStatement(sql);
        preparedStatement.setString(1, reader.getName());
        preparedStatement.executeUpdate();
        connectionSettingsData.newConnecting().close();
    }
}
