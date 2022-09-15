package com.booklibrary.service;

import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.dao.ReaderDAOImpl;
import com.booklibrary.entity.Reader;

import java.sql.SQLException;
import java.util.*;

public class ReaderServiceImpl implements ReaderService {

  private final Scanner scanner = new Scanner(System.in);
  private final ConnectionSettingsData connectionSettingsData = new ConnectionSettingsData();
  private final ReaderDAO readerDAO = new ReaderDAOImpl(connectionSettingsData);


  @Override
  public void printAllReaders() throws SQLException {
    System.out.println("Все читатели: ");
    readerDAO.findAllReader().forEach(System.out::println);
  }

  @Override
  public void addNewReader() throws SQLException {
    System.out.println("Укажите имя нового читателя: ");
    String readerName = scanner.nextLine();
    var reader = new Reader(readerName);
    readerDAO.addReaderDatabase(reader);
  }

  @Override
  public Reader findReaderById(Long readerId) throws SQLException {
    return readerDAO.findAllReader().stream()
        .filter(reader -> reader.getId() == readerId)
        .findAny()
        .orElse(null);
  }
}
