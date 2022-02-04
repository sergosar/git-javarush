package com.javarush.task.task19.task1906;

import java.io.*;

/*
Четные символы
Считать с консоли 2 имени файла.
Вывести во второй файл все символы с четным индексом.
Пример первого файла:
text in file
Вывод во втором файле:
eti ie
Закрыть потоки ввода-вывод
Требования:
1. Программа должна считывать имена файлов с консоли (используй BufferedReader).
2. BufferedReader для считывания данных с консоли должен быть закрыт.
3. Программа должна считывать содержимое первого файла (используй FileReader c конструктором String).
4. Поток чтения из файла (FileReader) должен быть закрыт.
5. Программа должна записывать во второй файл все байты из первого файла с четным индексом (используй FileWriter).
6. Поток записи в файл (FileWriter) должен быть закрыт.
*/
public class Solution {
    public static void main(String[] args)  {

        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();

        }
        try (FileReader fileReader = new FileReader(fileName1); FileWriter fileWriter = new FileWriter(fileName2)) {
            while (fileReader.ready()) {
                fileReader.read();
                fileWriter.write(fileReader.read());
            }

        } catch (IOException e) {

        }
    }

}


