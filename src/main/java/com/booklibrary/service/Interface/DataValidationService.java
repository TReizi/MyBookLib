package com.booklibrary.service.Interface;


public interface DataValidationService {
    boolean validationReader(long readerId);
    boolean validationBook(long bookId);

}
