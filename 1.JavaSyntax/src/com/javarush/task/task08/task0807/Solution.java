package com.javarush.task.task08.task0807;
import java.util.*;
/* Нужно создать два списка – LinkedList и ArrayList.
Требования:
1. Программа не должна выводить текст на экран.
2. Программа не должна считывать значения с клавиатуры.
3. Программа должна содержать только три метода.
4. Метод createArrayList() должен создавать и возвращать список ArrayList.
5. Метод createLinkedList() должен создавать и возвращать список LinkedList.
*/
public class Solution {
    public static Object createArrayList() {
        ArrayList arrayList = new ArrayList();//напишите тут ваш код
        return arrayList;
    }

    public static Object createLinkedList() {
        LinkedList linkedList = new LinkedList();
        return linkedList;//напишите тут ваш код

    }

    public static void main(String[] args) {
        createArrayList();
        createLinkedList();
    }
}
