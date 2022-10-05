package com.booklibrary.exceptionOutput;

public class ErrorMessagePrintService {
    public static void  userErrorOutput() {
        System.err.println("Проверьте правильность введённых данных.");
    }

    public static void daoBookErrorOutput(Exception e){
    System.err.println("Не удалось сохранить книгу, из-за ошибки БД "+ e);
    }

    public static void daoBorrowErrorOutput(Exception e){
        System.err.println("Не удалось сохранить взаимодействие, из-за ошибки БД "+ e);
    }

    public static void daoReaderErrorOutput (Exception e){
        System.err.println("Не удалось сохранить читателя, из-за ошибки БД "+ e);
    }
//    public static void menuOutput(){
//    System.out.println("Вы попытались воспользоваться данной функцией 3 раза. Воспользуйтесь другим функционалом программы.");
//    }
}
