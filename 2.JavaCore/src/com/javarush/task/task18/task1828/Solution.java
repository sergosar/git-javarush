package com.javarush.task.task18.task1828;
/* 
Прайсы 2
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается с одним из следующих наборов параметров:
-u id productName price quantity
-d id
Значения параметров:
где id - 8 символов
productName - название товара, 30 символов
price - цена, 8 символов
quantity - количество, 4 символа
-u - обновляет данные товара с заданным id
-d - производит физическое удаление товара с заданным id (все данные, которые относятся к переданному id)
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19847   Шорты пляжные синие           159.00  12
198479  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234

Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-u id productName price quantity" должна обновится информация о товаре в файле.
4. При запуске программы с параметрами "-d id" строка товара с заданным id должна быть удалена из файла.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        fileName = reader.readLine();
        reader.close();
        List<String> list = new ArrayList<>();

        if (args.length != 0) {
            reader = new BufferedReader(new FileReader(fileName));
            while (reader.ready()) list.add(reader.readLine());
            reader.close();
        }
        if (args[0].equals("-u")) {
            for (int i = 0; i < list.size(); i++) {
                int id = Integer.parseInt(list.get(i).substring(0, 8).trim());
                if (id == Integer.parseInt(args[1])) {
                    list.set(i, String.format("%-8d%-30s%-8s%-4s", id, args[2], args[3], args[4]));
                }
            }
        }
        if (args[0].equals("-d")) {
            for (int i = 0; i < list.size(); i++) {
                int id = Integer.parseInt(list.get(i).substring(0, 8).trim());
                if (id == Integer.parseInt(args[1])) {
                    list.remove(i);
                }
            }
        }
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < list.size() - 1; i++) {
            fileWriter.write(list.get(i));
            fileWriter.newLine();
        }
        fileWriter.write(list.get(list.size() - 1));
        fileWriter.close();
    }
}
