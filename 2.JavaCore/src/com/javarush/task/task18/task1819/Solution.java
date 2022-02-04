package com.javarush.task.task18.task1819;
/*
Объединение файлов
Считать с консоли 2 имени файла.
В начало первого файла записать содержимое второго файла так, чтобы получилось объединение файлов.
Закрыть потоки.
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения и считай его содержимое.
3. Затем, для первого файла создай поток для записи. Для второго - для чтения.
4. Содержимое первого и второго файла нужно объединить в первом файле.
5. Сначала должно идти содержимое второго файла, затем содержимое первого.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        reader.close();

        FileInputStream file1InputStream = new FileInputStream(fileName1);

        FileInputStream file2stream = new FileInputStream(fileName2);

        byte[] buffer = new byte[file1InputStream.available()] ;
        file1InputStream.read(buffer);
        FileOutputStream file1OutputStream = new FileOutputStream(fileName1);
        file1InputStream.close();
        while(file2stream.available()>0) {
           file1OutputStream.write(file2stream.read());
        }
        file1OutputStream.write(buffer);
        file1OutputStream.close();
        file2stream.close();
    }
}
