package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/*
Нити и байты
Читайте с консоли имена файлов, пока не будет введено слово "exit".
Передайте имя файла в нить ReadThread.
Нить ReadThread должна найти байт, который встречается в файле максимальное число раз, и добавить его в словарь resultMap,
где параметр String - это имя файла, параметр Integer - это искомый байт.
Закрыть потоки.
Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "exit".
2. Для каждого файла создай нить ReadThread и запусти ее.
3. После запуска каждая нить ReadThread должна создать свой поток для чтения из файла.
4. Затем, нити должны найти максимально встречающийся байт в своем файле и добавить его в словарь resultMap.
5. Поток для чтения из файла в каждой нити должен быть закрыт.
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = null;
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (s. equals("exit")) break;
            new ReadThread(s).start();
         }

    }

    public static class ReadThread extends Thread {
        FileInputStream fileInputStream = null;
        String fileName = null;
        public ReadThread(String fileName) {
            this.fileName = fileName;
            try {
                this.fileInputStream = new FileInputStream(fileName);//implement constructor body
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            HashMap<Integer, Integer> hashMap = new HashMap<>();
            BufferedReader reader = new BufferedReader(new InputStreamReader(fileInputStream));
            try {
                while (reader.ready()) {
                    Integer key = reader.read();
                    if (hashMap.containsKey(key)) hashMap.put(key, hashMap.get(key) + 1);
            else hashMap.put(key, 1);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            Integer max = Collections.max(hashMap.values());
            for (Integer i : hashMap.keySet()) {
                if (hashMap.get(i) == max) resultMap.put(fileName, i);
            }

        }

    }
}
