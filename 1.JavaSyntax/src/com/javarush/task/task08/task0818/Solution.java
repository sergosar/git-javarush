package com.javarush.task.task08.task0818;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
/* Только для богачей
Создать словарь (Map<String, Integer>) и занести в него десять записей по принципу: «фамилия» — «зарплата».
Удалить из словаря всех людей, у которых зарплата ниже 500.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Integer состоящих из 10 записей по принципу «фамилия» - «зарплата».
5. Метод removeItemFromMap() должен удалять из словаря всех людей, у которых зарплата ниже 500.
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String , Integer> hashMap = new HashMap<>();
        for(int i = 0 ; i < 10 ; i++) {
            hashMap.put("abc" + i , 495 + i);//напишите тут ваш код
        }
        return hashMap;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        Iterator<HashMap.Entry<String, Integer>> iterator= map.entrySet().iterator();//напишите тут ваш код
        while(iterator.hasNext()) {
            if (iterator.next().getValue()<500) iterator.remove();
        }
    }

    public static void main(String[] args) {

    }
}