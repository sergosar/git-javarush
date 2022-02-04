package com.javarush.task.task18.task1810;

/* 
DownloadException
1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.

Требования:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws DownloadException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = "";
        FileInputStream stream;
        while (true) {
            try {
                fileName = reader.readLine();

            } catch (IOException e) {
            }
            try {
                stream = new FileInputStream(fileName);
                try {
                    if (stream.available() < 1000) {
                        throw new DownloadException();

                    }
                } catch (IOException e) {

                } finally {
                    try {
                        stream.close();
                    } catch (IOException e) {

                    }
                }

            } catch (FileNotFoundException e) {

            }
        }


    }

    public static class DownloadException extends Exception {

    }
}
