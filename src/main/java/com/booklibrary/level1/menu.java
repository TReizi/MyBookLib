package com.booklibrary.level1;


import java.util.Scanner;


import static com.booklibrary.level1.Data.BookData.*;
import static com.booklibrary.level1.Data.ReadersData.getAllReaders;



public class menu {
    public static void start() {
        while (true) {


            textMenu();

            Scanner scMenu = new Scanner(System.in);
            String c = scMenu.nextLine();
            Object value = switch (c) {
                case "1" -> getAllBooks();
                case "2" -> getAllReaders();



                case "exit" ->exit();

                default -> throw new IllegalStateException("Unexpected value: " + c);
            };

        }
    }

    public static int exit() {
        System.out.println("Bay!");
        System.exit(0);
        return exit();
    }


    public static void textMenu(){
        String textMenu= """
                Меню библиотеки:
                [1] Список всех книг.
                [2] Список всех читателей.
                
                [exit] Выход.
                """;
        System.out.println(textMenu);
    }
}

