package com.javarush.task.task18.task1818;
/*
Два в одном
Считать с консоли 3 имени файла.
Записать в первый файл содержимого второго файла, а потом дописать в первый файл содержимое третьего файла.
Закрыть потоки.

Требования:
1. Программа должна три раза считать имена файлов с консоли.
2. Для первого файла создай поток для записи. Для двух других - потоки для чтения.
3. Содержимое второго файла нужно переписать в первый файл.
4. Содержимое третьего файла нужно дописать в первый файл (в который уже записан второй файл).
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws  Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2, filname3;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        filname3 = reader.readLine();
        reader.close();
        FileOutputStream file1stream = new FileOutputStream(fileName1);
        FileInputStream file2stream = new FileInputStream(fileName2);
        FileInputStream file3stream = new FileInputStream(filname3);
        byte b;
        while(file2stream.available()>0) {
            file1stream.write(file2stream.read());
        }
        file2stream.close();
        while(file3stream.available()>0) {
            file1stream.write(file3stream.read());
        }
        file1stream.close();
        file3stream.close();


    }
}
