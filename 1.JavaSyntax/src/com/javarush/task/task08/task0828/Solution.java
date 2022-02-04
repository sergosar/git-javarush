package com.javarush.task.task08.task0828;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Номер месяца
Программа вводит с клавиатуры имя месяца и выводит его номер на экран в виде: «May is 5 month».
Используйте коллекции.
Требования:
1. Программа должна выводить текст на экран.
2. Программа должна считывать значения с клавиатуры.
3. Класс Solution должен содержать один метод.
4. Программа должна использовать коллекции.
5. Программа должна считывать с клавиатуры имя месяца и выводить его номер на экран по заданному шаблону.
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        HashMap<String , String> hashMap = new HashMap<>();
        hashMap.put("January","January is 1 month");
        hashMap.put("February","February is 2 month");
        hashMap.put("March","March is 3 month");
        hashMap.put("April","April is 4 month");
        hashMap.put("May","May is 5 month");
        hashMap.put("June","June is 6 month");
        hashMap.put("July","July is 7 month");
        hashMap.put("August","August is 8 month");
        hashMap.put("September","September is 9 month");
        hashMap.put("October","October is 10 month");
        hashMap.put("November","November is 11 month");
        hashMap.put("December","December is 12 month");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String month = reader.readLine();
        System.out.println(hashMap.get(month));

    }

}
