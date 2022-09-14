package com.booklibrary.service;

import com.booklibrary.dao.ReaderDAO;
import com.booklibrary.entity.Reader;

import java.sql.SQLException;
import java.util.*;

public class ReaderServiceImpl implements ReaderService {


  private final Scanner scanner = new Scanner(System.in);
  private final ReaderDAO readerDAO;
  public  ReaderServiceImpl(ReaderDAO readerDAO){
    this.readerDAO = readerDAO;
  }
//  public void generateReaders() {
//    Reader r1 = new Reader(1, "Artem");
//    Reader r2 = new Reader(2, "Oleg");
//    Reader r3 = new Reader(3, "Nina");
//    readerList.add(r1);
//    readerList.add(r2);
//    readerList.add(r3);
//  }

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
  public Reader findReaderById(Long readerId) {
    return readerList.stream().filter(reader -> reader.getId() == readerId).findAny().orElse(null);
  }
}
