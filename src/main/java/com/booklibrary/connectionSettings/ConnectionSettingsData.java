package com.booklibrary.connectionSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSettingsData {
  public final String DB_USERNAME = "bestuser";
  public final String DB_PASSWORD = "bestuser";
  public final String DB_URL = "jdbc:mysql://127.0.0.1:3306/my_db";

  public final Connection newConnecting() throws SQLException {
    Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    return connection;
  }
}
