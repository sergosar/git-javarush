package com.javarush.task.task08.task0815;
import java.util.*;

/* Создать словарь (Map<String, String>) занести в него десять записей по принципу «Фамилия» — «Имя».
Проверить сколько людей имеют совпадающие с заданным именем или фамилией.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей по принципу «Фамилия» - «Имя».
5. Метод getCountTheSameFirstName() должен возвращать число людей у которых совпадает имя.
6. Метод getCountTheSameLastName() должен возвращать число людей у которых совпадает фамилия.
*/
public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int u= 0 ; u < 10 ; u++) {
            map.put("A" + u , "B" + u);//напишите тут ваш код
        }
        return map;
    }

    public static int getCountTheSameFirstName(HashMap<String, String> map, String name) {
        int count = 0;
        Iterator<String> iterator = map.values().iterator();
        while (iterator.hasNext()) {
            if(iterator.next().equals(name)) count++;
        }
        return count;
    }

    public static int getCountTheSameLastName(HashMap<String, String> map, String lastName) {
        int count = 0;
        Iterator<String> iterator = map.keySet().iterator();//напишите тут ваш код
        while (iterator.hasNext()) {
            if(iterator.next().equals(lastName)) count++;
        }
        return count;
    }

    public static void main(String[] args) {

    }
}
