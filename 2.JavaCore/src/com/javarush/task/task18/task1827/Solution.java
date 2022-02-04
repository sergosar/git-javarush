package com.javarush.task.task18.task1827;
/*
Прайсы
CrUD для таблицы внутри файла.
Считать с консоли имя файла для операций CrUD.
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов.
productName - название товара, 30 символов.
price - цена, 8 символов.
quantity - количество, 4 символа.
-c - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя
 максимальный id, найденный в файле.
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины.
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
Требования:
1. Программа должна считать имя файла для операций CrUD с консоли.
2. При запуске программы без параметров список товаров должен остаться неизменным.
3. При запуске программы с параметрами "-c productName price quantity" в конец файла должна добавится новая строка с товаром.
4. Товар должен иметь следующий id, после максимального, найденного в файле.
5. Форматирование новой строки товара должно четко совпадать с указанным в задании.
6. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        fileName = reader.readLine();
        reader.close();
        if (args.length != 0) {
            reader = new BufferedReader(new FileReader(fileName));
            int idMax = 0;
            while (reader.ready()) {
                int id = Integer.parseInt(reader.readLine().substring(0, 8).trim());
                if (idMax < id) {
                    idMax = id;
                }
            }
            idMax++;

            reader.close();
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.newLine();
            writer.write(String.format("%-8d%-30s%-8s%-4s", idMax, args[1], args[2], args[3]));
            writer.close();
        }
    }
}
