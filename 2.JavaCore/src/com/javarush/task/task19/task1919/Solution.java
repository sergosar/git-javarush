package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Double> map = new TreeMap<>();


        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            while (reader.ready()) {
                String s = reader.readLine();
                String[] str = s.split(" ");

                if (map.containsKey(str[0])) map.put(str[0], map.get(str[0]) + Double.parseDouble(str[1]));
                else map.put(str[0], Double.parseDouble(str[1]));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String s : map.keySet()) {
            System.out.println(s + " " + map.get(s));

        }
    }
}
