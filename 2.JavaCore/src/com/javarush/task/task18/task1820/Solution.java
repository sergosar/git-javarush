package com.javarush.task.task18.task1820;
/*
Округление чисел
Считать с консоли 2 имени файла.
Первый файл содержит вещественные(дробные) числа, разделенные пробелом. Например, 3.1415.
Округлить числа до целых и записать через пробел во второй файл.
Закрыть потоки.
Принцип округления:
3.49 - 3
3.50 - 4
3.51 - 4
-3.49 - -3
-3.50 - -3
-3.51 - -4
Требования:
1. Программа должна два раза считать имена файлов с консоли.
2. Для первого файла создай поток для чтения. Для второго - поток для записи.
3. Считать числа из первого файла, округлить их и записать через пробел во второй.
4. Должны соблюдаться принципы округления, указанные в задании.
5. Созданные для файлов потоки должны быть закрыты.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName1, fileName2;
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        reader.close();
        FileInputStream streamIn = new FileInputStream(fileName1);
        FileOutputStream streamOut = new FileOutputStream(fileName2);
        reader = new BufferedReader(new InputStreamReader(streamIn));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(streamOut));
        while (reader.ready()) {
            String s = reader.readLine();
            String[] arr = s.split(" ");
            for (String str: arr ) {
                int c = Math.round(Float.parseFloat(str));
                writer.write(String.valueOf(c));
                writer.write(" ");
            }
        }
        reader.close();writer.close();

    }
}
