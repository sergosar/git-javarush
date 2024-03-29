package com.javarush.task.task15.task1513;

/* 
Требования:
1. В классе Car не должно быть явно реализованных конструкторов без параметров.
2. В классе Machine не должно быть явно реализованных конструкторов без параметров.
3. Класс Car должен быть потомком класса Machine.
4. В коде не должно быть явного наследования от Object(extends Object).
5. Класс Car не должен явно наследовать интерфейс Runnable.
*/

public class Solution {
    public static void main(String[] args) {
    }

    public interface Runnable {

    }

    public class Machine implements Runnable {

    }

    public class Car extends Machine {

    }
}
