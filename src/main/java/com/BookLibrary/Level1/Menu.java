package com.BookLibrary.Level1;

import java.util.Scanner;

import static com.BookLibrary.Level1.Data.Book_data.GetAllBook;
import static com.BookLibrary.Level1.Data.Readers_data.GetAllReaders;

public class Menu {
    public static void Start() {
        loop:
        for (int i = 0;; i++) {
            System.out.println("Меню библиотеки: ");
            System.out.println("1 - все книги в Библиотеке");
            System.out.println("2 - все читатели в Библиотеке");
            System.out.println("exit - ВЫХОД");

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();


            switch (c) {
                case "1":
                    System.out.println("Все книги: ");
                    GetAllBook();
                    System.out.println("----------");
                    continue loop;
                case "2":
                    System.out.println("Все читатели:");
                    GetAllReaders();
                    System.out.println("----------");
                    continue loop;
                case "exit":
                    System.out.println("Bay!");
                    break loop;
                default:
                    System.out.println("Мяу");//заглушка

            }
        }
    }
}
