package com.booklibrary.service;

import com.booklibrary.UI.InputClient;
import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.dao.ReaderDAOImpl;
import com.booklibrary.entity.Reader;

import java.sql.SQLException;


public class ReaderServiceImpl implements ReaderService {

  private final ConnectionSettingsData connectionSettingsData = new ConnectionSettingsData();
  private final ReaderDAO readerDAO = new ReaderDAOImpl(connectionSettingsData);
  private final InputClient inputClient = new InputClient();


  @Override
  public void printAllReaders() throws SQLException {
    System.out.println("Все читатели: ");
    readerDAO.findAllReader().forEach(System.out::println);
  }

  @Override
  public void addNewReader() throws SQLException {
    System.out.println("Укажите имя нового читателя: ");
    var reader = new Reader(inputClient.inputClientAddNewReader());
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
