package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = null;
        fileName = reader.readLine();
        reader.close();
        File file = new File(fileName);


        FileInputStream stream = null;
        stream = new FileInputStream(fileName);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream));
        int temp,max;
        max=65535;

        while (reader1.ready()) {
            temp = reader1.read();
            if (temp <  max) max = temp;


        }
        stream.close();
        System.out.println(max);
    }
}
