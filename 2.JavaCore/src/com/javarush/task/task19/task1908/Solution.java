package com.javarush.task.task19.task1908;
/* 
Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки.
Пример тела файла:
12 text var2 14 8v 1
Результат:
12 14 1

Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй BufferedReader c конструктором FileReader).
4. Поток чтения из файла (BufferedReader) должен быть закрыт.
5. Программа должна записывать во второй файл все числа, через пробел, из первого файла (используй BufferedWriter с конструктором FileWriter).
6. Поток записи в файл (BufferedWriter) должен быть закрыт.
*/


import java.io.*;

public class Solution {
    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName1));
             BufferedWriter writer = new BufferedWriter(new FileWriter(fileName2))) {
            StringBuilder s = new StringBuilder();
            String[] arr;
            while (reader.ready()) {
                s.append(reader.readLine());
            }
            //System.out.println(s);
            arr = s.toString().split(" ");
            for (int i = 0; i < arr.length; i++) {
                if (isInteger(arr[i])) {
                    writer.write(arr[i] + " ");
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
