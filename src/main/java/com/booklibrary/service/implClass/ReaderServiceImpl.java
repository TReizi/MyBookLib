package com.booklibrary.service.implClass;

import com.booklibrary.UI.InputClient;
import com.booklibrary.connectionSettings.ConnectionSettingsData;
import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.dao.implDaoClass.ReaderDAOImpl;
import com.booklibrary.entity.Reader;
import com.booklibrary.service.ReaderService;

public class ReaderServiceImpl implements ReaderService {

  private final ConnectionSettingsData connectionSettingsData = new ConnectionSettingsData();
  private final ReaderDAO readerDAO = new ReaderDAOImpl(connectionSettingsData);
  private final InputClient inputClient = new InputClient();

  @Override
  public void printAllReaders() {
    System.out.println("Все читатели: ");
    readerDAO.findAllReader().forEach(System.out::println);
  }

  @Override
  public void addNewReader() {
    System.out.println("Укажите имя нового читателя: ");
    var reader = new Reader(inputClient.inputClientAddNewReader());
    readerDAO.addReaderDatabase(reader);
  }

  @Override
  public Reader findReaderById(Long readerId) {
    return readerDAO.findAllReader().stream()
        .filter(reader -> reader.getId() == readerId)
        .findAny()
        .orElse(null);
  }
}
