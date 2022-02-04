package com.javarush.task.task19.task1907;
/*
Считаем слово
Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов "world", которые встречаются в файле.
Закрыть потоки.
Требования:
1. Программа должна считывать имя файла с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна выводить в консоль количество слов "world", которые встречаются в файле.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        int count = 0;
        StringBuilder str = new StringBuilder();


        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
        }

        try (FileReader reader = new FileReader(fileName)) {
            while (reader.ready()) {

                str.append((char)reader.read());

            }
        } catch (IOException e) {
        }
        String[] arr = str.toString().split("[\\W]");
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equalsIgnoreCase("world")) count++;
           // System.out.println(arr[i]);
        }


        System.out.println(count);

    }
}
