package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
/*
Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить данные на экран.
3. Выведенные слова должны быть упорядочены по возрастанию.
4. Выведенные числа должны быть упорядочены по убыванию.
5. Метод main должен использовать метод sort.
6. Метод sort должен использовать метод isGreaterThan.
7. Метод sort должен использовать метод isNumber.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }


        String[] array = list.toArray(new String[list.size()]);

        sort(array);


        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<String> arrayListString = new ArrayList<>();
        ArrayList<Integer> arrayListInteger = new ArrayList<>();
        ArrayList<Boolean> arrayListBoolean = new ArrayList<>();

        for (String s : array) {
            if (isNumber(s)) {
                arrayListInteger.add(Integer.parseInt(s));
                arrayListBoolean.add(true); // число
            } else {
                arrayListString.add(s);
                arrayListBoolean.add(false); // строка
            }
        }

        arrayListInteger.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        arrayListString.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (isGreaterThan(o1, o2)) return 1;
                else return -1;
            }
        });
        int i = 0;
        for (Boolean b : arrayListBoolean) {
            if (b.equals(true)) array[i] = "" + arrayListInteger.remove(0);
            else array[i] = arrayListString.remove(0);
            i++;
        }
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
