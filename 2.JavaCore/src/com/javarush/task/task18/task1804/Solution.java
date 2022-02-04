package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;

/* 
Самые редкие байты
Самые редкие байты
Ввести с консоли имя файла.
Найти байт или байты с минимальным количеством повторов.
Вывести их на экран через пробел.
Закрыть поток ввода-вывода.


Требования:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль через пробел должны выводиться все байты из файла с минимальным количеством повторов.
4. Данные в консоль должны выводится в одну строку.
5. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        while (reader.ready()) {
            Integer key = reader.read();
            if (hashMap.containsKey(key)) hashMap.put(key, hashMap.get(key) + 1);
            else hashMap.put(key, 1);
        }
        reader.close();
        //Integer max = Collections.max(hashMap.values());
        for (Integer i : hashMap.keySet()) {
            if (hashMap.get(i) == 1) System.out.print(i + " ");
        }

    }
}
