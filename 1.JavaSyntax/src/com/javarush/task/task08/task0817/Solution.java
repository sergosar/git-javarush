package com.javarush.task.task08.task0817;
import java.util.*;

/*
Создать словарь (Map<String, String>) занести в него десять записей по принципу «фамилия» — «имя».
Удалить людей, имеющих одинаковые имена.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только четыре метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, String состоящих из 10 записей.
5. Метод removeTheFirstNameDuplicates() должен удалять из словаря всех людей, имеющие одинаковые имена.
6. Метод removeTheFirstNameDuplicates() должен вызывать метод removeItemFromMapByValue().
*/
public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> map = new HashMap<>();
        for (int r= 0 ; r< 9 ; r++) {
            map.put("Stallone" + r , "123"+ r);
        }
        map.put("Stallone" , "1235");
        return map;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        Collection<String> names = new ArrayList<String>(map.values()) ;
        for (String name: names ) {
            if (Collections.frequency(names , name) > 1) removeItemFromMapByValue(map, name);
        }

       /* HashMap<String, Integer> freq = new HashMap<>();
        for (String name : names) {
            int i = Collections.frequency(map.values(), name);
            freq.put(name, i);

        }
        for (HashMap.Entry<String, Integer> entry : freq.entrySet()) {
            if(entry.getValue() > 1) {
                int k = entry.getValue();
                for (int n = 0 ; n< k ; n ++) removeItemFromMapByValue(map, entry.getKey());
            }
        }
        System.out.println(freq);*/

    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {
        HashMap<String, String> hashMap = createMap();
        removeTheFirstNameDuplicates(hashMap);
        Set<String> set = hashMap.keySet();



        System.out.println(hashMap);
        System.out.println(set);

    }
}
