package com.javarush.task.task12.task1204;

/*То ли птица, то ли лампа
Написать метод, который определяет, объект какого класса ему передали, и выводит на экран одну из надписей: Кошка, Собака, Птица, Лампа.
Требования:
1. Программа должна выводить текст на экран.
2. Класс Cat менять нельзя.
3. Класс Dog менять нельзя.
4. Класс Bird менять нельзя.
5. Класс Lamp менять нельзя.
6. Метод printObjectType() должен выводить на экран одну из надписей, в зависимости от переданного объекта. Например "Лампа" для объектов типа Solution.Lamp.
*/
public class Solution {
    public static void main(String[] args) {
        printObjectType(new Cat());
        printObjectType(new Bird());
        printObjectType(new Lamp());
        printObjectType(new Cat());
        printObjectType(new Dog());
    }

    public static void printObjectType(Object o) {
        String className = o.getClass().getCanonicalName();
        switch (className) {
            case "com.javarush.task.task12.task1204.Solution.Cat":
                System.out.println("Кошка");
                break;
            case "com.javarush.task.task12.task1204.Solution.Bird":
                System.out.println("Птица");
                break;
            case "com.javarush.task.task12.task1204.Solution.Lamp":
                System.out.println("Лампа");
                break;

            case "com.javarush.task.task12.task1204.Solution.Dog":
                System.out.println("Собака");
                break;
        }
    }

    public static class Cat {
    }

    public static class Dog {
    }

    public static class Bird {
    }

    public static class Lamp {
    }
}
