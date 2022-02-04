package com.javarush.task.task19.task1902;

import java.io.FileOutputStream;
import java.io.IOException;

/*
Адаптер
Используй класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter.
Требования:
1. AmigoStringWriter должен быть интерфейсом.
2. Класс AdapterFileOutputStream должен реализовывать интерфейс AmigoStringWriter.
3. Класс AdapterFileOutputStream должен содержать приватное поле fileOutputStream типа FileOutputStream.
4. Класс AdapterFileOutputStream должен содержать конструктор с параметром FileOutputStream.
5. Метод flush() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
6. Метод writeString(String s) класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
7. Метод close() класса AdapterFileOutputStream должен делегировать полномочие такому же методу fileOutputStream.
*/
public class AdapterFileOutputStream implements AmigoStringWriter {
    private FileOutputStream fileOutputStream;

    public static void main(String[] args) {
        String fName = "Ivanov, Ivan";
        System.out.println(fName.substring(fName.indexOf(" ")+1, fName.length()));
        System.out.println(fName.substring(0,fName.indexOf(" ")-1));
        System.out.println("//+" + "38(050)123-45-67".replaceAll("[\\D]", ""));

    }

    public AdapterFileOutputStream(FileOutputStream fileOutputStream) {
        this.fileOutputStream = fileOutputStream;
    }

    @Override
    public void flush() throws IOException {
        fileOutputStream.flush();
    }

    @Override
    public void writeString(String s) throws IOException {
        byte[] buffer = s.getBytes();
    fileOutputStream.write(buffer);
    }

    @Override
    public void close() throws IOException {
        fileOutputStream.close();

    }
}

