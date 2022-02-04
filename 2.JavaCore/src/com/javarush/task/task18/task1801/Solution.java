package com.javarush.task.task18.task1801;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Требования:
1.	Программа должна считывать имя файла с консоли.
2.	Для чтения из файла используй поток FileInputStream.
3.	В консоль должен выводиться максимальный байт, считанный из файла.
4.	Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        fileName = reader.readLine();
        reader.close();
        File file = new File(fileName);


        FileInputStream stream = null;
        stream = new FileInputStream(fileName);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream));
        int temp,max;
        max=0;

        while (reader1.ready()) {
            temp = reader1.read();
            if (temp >  max) max = temp;
            System.out.println(temp);


        }


        stream.close();

        System.out.println(max);
    }
}
