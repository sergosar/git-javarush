package com.javarush.task.task13.task1326;

import java.io.*;
import java.util.TreeSet;

/*
Сортировка четных чисел из файла
1. Ввести имя файла с консоли.
2. Прочитать из него набор чисел.
3. Вывести на консоль только четные, отсортированные по возрастанию.
Пример ввода:
5
8
11
3
2
10
Пример вывода:
2
8
10
Требования:
1. Программа должна считывать данные с консоли.
2. Программа должна вывести на экран все четные числа считанные из файла отсортированные по возрастанию.
3. Программа должна выводить данные на экран.
4. Программа должна закрывать поток чтения из файла(FileInputStream).
*/
public class Solution {
    public static void main(String[] args)  {
        TreeSet<Integer> numbers = new TreeSet<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        try {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String str;
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(fileInputStream));
        try {
            while ((str = reader1.readLine())!=null) {
                int k = Integer.parseInt(str);
                if (k % 2 == 0) numbers.add(k);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (Integer i : numbers) {
            System.out.println(i);
        }

        try {
            fileInputStream.close();
            //reader.close();
            reader1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
