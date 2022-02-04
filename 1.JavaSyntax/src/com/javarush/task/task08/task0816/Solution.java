package com.javarush.task.task08.task0816;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
/* 
Создать словарь (Map<String, Date>) и занести в него десять записей по принципу: «фамилия» — «дата рождения».
Удалить из словаря всех людей, родившихся летом.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Класс Solution должен содержать только три метода.
4. Метод createMap() должен создавать и возвращать словарь HashMap с типом элементов String, Date состоящий из 10 записей.
5. Метод removeAllSummerPeople() должен удалять из словаря всех людей, родившихся летом.
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        for (int r= 0 ; r< 10 ; r++) {
            map.put("Stallone" + r, new Date("AUGUST 31 198" + r));
        }
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        Iterator<HashMap.Entry<String, Date>> iterator =  map.entrySet().iterator();
        while (iterator.hasNext()) {
            int month = iterator.next().getValue().getMonth();
            if (month< 8 && month > 4) iterator.remove();
        }

    }

    public static void main(String[] args) {
//        HashMap<String, Date> map = createMap();
//         for(HashMap.Entry<String, Date> o : map.entrySet()){
//            System.out.println(o.getValue().getMonth());
//        }
//        System.out.println("__________________");
//        removeAllSummerPeople(map);
//        for(HashMap.Entry<String, Date> o : map.entrySet()){
//            System.out.println(o.getValue().getMonth());
//        }

    }
}
