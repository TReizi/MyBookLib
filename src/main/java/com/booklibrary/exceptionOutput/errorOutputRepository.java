package com.booklibrary.exceptionOutput;

public class errorOutputRepository {
    public static void  userErrorOutput() {
        System.out.println("Проверьте правильность введённых данных.\nПовторите ввод:");
    }

    public static void daoErrorOutput(){
    System.out.println("Проблема с базой данных, попробуйте ещё раз, после третьей попытке соединение будет разорвано");
    }
    public static void menuOutput(){
    System.out.println("Вы попытались воспользоваться данной функцией 3 раза. Воспользуйтесь другим функционалом программы.");
    }
}
