package com.javarush.task.task18.task1808;

/*
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.
Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2, fileName3;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        fileName3 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(fileName1);

        FileOutputStream outputStream = new FileOutputStream(fileName2);
        byte[] buffer = new byte[inputStream.available()];
        int count = inputStream.read(buffer);
        inputStream.close();
        if (count % 2 == 0) {
            outputStream.write(buffer, 0, count / 2);
            outputStream.close();
            outputStream = new FileOutputStream(fileName3);
            outputStream.write(buffer, count / 2, count / 2);
        } else {
            outputStream.write(buffer, 0, count / 2 + 1);
            outputStream = new FileOutputStream(fileName3);
            outputStream.close();
            outputStream.write(buffer, count / 2 + 1, count / 2);

        }
        outputStream.close();


    }
}
