package com.booklibrary.connectionSettings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSettingsData {
  public static final String DB_USERNAME = "root";
  public static final String DB_PASSWORD = "bestuser";
  public static final String DB_URL = "jdbc:mysql://localhost:3306/my_db";

  public static Connection getNewConnection() {
    try {
      return DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
    } catch (SQLException e) {
      System.err.println(
          "\"Извините, у Вас потеря соединения с базой данных или база данных недоступна. "+ e);
      System.exit(1);
    }
    return null;
  }
}
