package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        //str = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";
        int stringNumber = -1;
        ArrayList<StringBuffer> arrayList = new ArrayList<>();
        StringBuffer objValue = new StringBuffer();
        boolean value = false;
        boolean key = true;

        for (char c : str.toCharArray()) {
            if (c == '=') {
                key = false;
                if (arrayList.get(stringNumber).toString().equals("obj")) {
                    value = true;
                }
                continue;
            }
            if (c == '?' || c == '&') {
                arrayList.add(new StringBuffer());
                stringNumber++;
                value = false;
                key = true;
                continue;
            }
            if (!arrayList.isEmpty() && !value && key) arrayList.get(stringNumber).append(c);
            if (value) objValue.append(c);

        }
        for (StringBuffer stringBuffer : arrayList) {
            System.out.print(stringBuffer + " ");
        }
        System.out.println();
        for (StringBuffer stringBuffer : arrayList) {
            if (stringBuffer.toString().equals("obj")) {
                try {
                    alert(Double.parseDouble(objValue.toString()));
                } catch (NumberFormatException e) {
                    alert(objValue.toString());//not a double
                }
            }
        }

        //add your code here
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
