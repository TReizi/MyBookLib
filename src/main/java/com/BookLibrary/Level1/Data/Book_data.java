package com.BookLibrary.Level1.Data;

import com.BookLibrary.Level1.entity.Book_object;


import java.util.ArrayList;

public class Book_data {

    public static void GetAllBook () {
        ArrayList<Book_object> bookArray = new ArrayList<>();
        Book_object b1 = new Book_object(1, "451 по Фаренгейту", "Рэй Брэдбери");
        Book_object b2 = new Book_object(2, "1984", "Рэй Джордж Оруэлл");
        Book_object b3 = new Book_object(1, "Мастер и Маргарита", "Михаил Булгаков");
        bookArray.add(b1);
        bookArray.add(b2);
        bookArray.add(b3);
        System.out.println(bookArray);

    }

}
