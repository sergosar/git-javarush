package com.javarush.task.task10.task1006;

/* 
Задача №6 на преобразование целых типов
*/

public class Solution {
    public static void main(String[] args) {
        short b =  45;
        //System.out.println(b);
        char c =  'c'; //99
        //System.out.println(c);
        //System.out.println(c/1);
        short s = (short) 1005.22;
        //System.out.println(s);
        int i =  150000;
        //System.out.println(i);
        float f =  4.10f;
        //System.out.println(f);
        double d =  1.256d;
       // System.out.println(d);
        double result = (f * b) + (i / c) - (d * s) + 562.78d;
        System.out.println("result: " + result);
        //System.out.println(i/c);
    }
}