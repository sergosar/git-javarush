package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
/*
Собираем файл
Собираем файл из кусочков.
Считывать с консоли имена файлов.
Каждый файл имеет имя: [someName].partN.
Например, Lion.avi.part1, Lion.avi.part2, ..., Lion.avi.part37.
Имена файлов подаются в произвольном порядке. Ввод заканчивается словом "end".
В папке, где находятся все прочтенные файлы, создать файл без суффикса [.partN].
Например, Lion.avi.
В него переписать все байты из файлов-частей используя буфер.
Файлы переписывать в строгой последовательности, сначала первую часть, потом вторую, ..., в конце - последнюю.
Закрыть потоки.
Требования:
1. Программа должна считывать имена файлов с консоли, пока не будет введено слово "end".
2. Создай поток для записи в файл без суффикса [.partN] в папке, где находятся все считанные файлы.
3. В новый файл перепиши все байты из файлов-частей *.partN.
4. Чтение и запись должны происходить с использованием буфера.
5. Созданные для файлов потоки должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> names = new ArrayList<>();
       // names.add("e:/2.txt.part2");names.add("e:/1.txt.part1");  names.add("e:/3.txt.part3");
        while (true) {
            try {
                String name = reader.readLine();
                if (name.equals("end")) break;
                else names.add(name);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
//        for (int i = 0 ; i < names.size(); i ++) {
//            System.out.println(names.get(i));
//
//        }
        names.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                String[] arrS1 = o1.split("\\.");
                String[] arrS2 = o2.split("\\.");
               // for (int i = 0; i < arrS1.length; i++) System.out.println(arrS1[i]);
                int length = arrS1.length;
                //System.out.println(length);
                String a = arrS1[length-1].replaceAll("part", "");
               // System.out.println(a);
                String b = arrS2[length-1].replace("part", "");
                //System.out.println(b);
                return Integer.parseInt(a) - Integer.parseInt(b);
            }
        });
//        for (int i = 0 ; i < names.size(); i ++) {
//            System.out.println(names.get(i));
//
//        }

        String newAddress = names.get(0).replaceAll("\\.part.+$", "");
       // System.out.println(newAddress);
        FileOutputStream outputStream= null;
        try {
             outputStream= new FileOutputStream(newAddress, true);
            for (String s : names) {
                FileInputStream fileInputStream = new FileInputStream(s);
                try {
                    byte[] buffer = new byte[fileInputStream.available()];
                    fileInputStream.read(buffer);
                    outputStream.write(buffer);

                } catch (IOException e) {

                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } finally {
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}







