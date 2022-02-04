package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
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
        double max = Collections.max(map.values());
        for (Map.Entry<String, Double> entry: map.entrySet()) {
            if(entry.getValue() == max) System.out.println(entry.getKey());
        }
    }
}
