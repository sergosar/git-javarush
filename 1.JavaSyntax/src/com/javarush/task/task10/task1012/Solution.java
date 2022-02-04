package com.javarush.task.task10.task1012;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/*
Количество букв
Ввести с клавиатуры 10 строчек и подсчитать в них количество различных букв (для 33 букв алфавита). Результат вывести на экран в алфавитном порядке.
Пример вывода:
а 5
б 8
в 3
г 7
д 0
…
я 9
Требования:
1. Программа должна считывать данные с клавиатуры.
2. Программа должна выводить текст на экран.
3. Выведенный текст должен содержать 33 строки.
4. Каждая строка вывода должна содержать букву русского алфавита, пробел и сколько раз буква встречалась в введенных строках.
*/
public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String abc = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
        char[] abcArray = abc.toCharArray();
        LinkedHashMap<Character, Integer> result= new LinkedHashMap<>();
        //TreeMap<Character , Integer> result = new TreeMap<>();
        for (int i = 0; i < abcArray.length; i++) {
            result.put(abcArray[i], 0);
        }
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            String s = reader.readLine();
            list.add(s.toLowerCase());
        }
        for (String s: list) {
            char[] temp = s.toCharArray();
            for (int i= 0 ; i < temp.length; i ++) {
                if (result.containsKey(temp[i]))
                result.put(temp[i], result.get(temp[i])+ 1);
            }
        }
               for (Map.Entry<Character, Integer> entry: result.entrySet()) {
            System.out.println(entry.getKey()+ " " + entry.getValue());
        }
    }

}
