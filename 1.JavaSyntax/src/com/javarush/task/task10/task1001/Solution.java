package com.javarush.task.task10.task1001;

/* 
Задача №1 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        int a = 0;
        int b = (byte) a + 46;
        byte c = (byte) (a * b);
        double f = (short) 1234.15;
        System.out.println((short)11111408543l);
        long d = (char) (a + f / c + b);
        System.out.println(d);
    }
}
