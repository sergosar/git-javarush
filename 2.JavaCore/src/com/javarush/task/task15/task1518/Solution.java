package com.javarush.task.task15.task1518;
/*
Статики и котики
1. В классе Solution создай класс Cat с публичным полем name типа String.
2. В статическом блоке создай объект типа Cat и присвой его переменной cat(не забудь инициализировать поле name).
3. В классе Cat не создавай конструкторы с параметрами.
4. В статическом блоке выведи имя созданного кота на экран.
Требования:
1. Класс Cat должен быть создан внутри класса Solution и быть статическим.
2. В классе Cat должно присутствовать публичное поле name типа String.
3. Переменная cat должна быть инициализирована в статическом блоке.
4. В статическом блоке на экран должно быть выведено имя созданного кота.
5. Класс Cat не должен содержать конструкторы с параметрами.
*/

public class Solution {
    public static Cat cat;
    public static class Cat {
        public String name;

    }
    static {
        cat = new Cat();
        cat.name = "a";
        System.out.println(cat.name);
    }
    public static void main(String[] args) {

    }
}
