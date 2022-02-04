package com.javarush.task.task10.task1013;
/* 
Конструкторы класса Human
Напиши класс Human с 6 полями.
Придумай и реализуй 10 различных конструкторов для него.
Каждый конструктор должен иметь смысл.
Требования:
1. Программа не должна считывать данные с клавиатуры.
2. В классе Human должно быть 6 полей.
3. Все поля класса Human должны быть private.
4. В классе Human должно быть 10 конструкторов.
5. Все конструкторы класса Human должны быть public.
*/

public class Solution {
    public static void main(String[] args) {

    }

    public static class Human {
        private String name;
        private String secondName;
        private int age;
        private String profession;
        private String hobby;
        private boolean sex;

        public Human(String name) {
            this.name = name;
        }

        public Human(String name, boolean sex) {
            this.name = name;
            this.sex = sex;
        }

        public Human(String name, String secondName) {
            this.name = name;
            this.secondName = secondName;
        }

        public Human(String name, String secondName, int age) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
        }

        public Human(String name, String secondName, int age, String profession) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.profession = profession;
        }

        public Human(String name, String secondName, int age, String profession, String hobby) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.profession = profession;
            this.hobby = hobby;
        }

        public Human(String name, String secondName, int age, String profession, String hobby, boolean sex) {
            this.name = name;
            this.secondName = secondName;
            this.age = age;
            this.profession = profession;
            this.hobby = hobby;
            this.sex = sex;
        }

        public Human(int age, boolean sex) {
            this.age = age;
            this.sex = sex;
        }

        public Human(int age, String profession, String hobby) {
            this.age = age;
            this.profession = profession;
            this.hobby = hobby;
        }

        public Human(int age, String profession, String hobby, boolean sex) {
            this.age = age;
            this.profession = profession;
            this.hobby = hobby;
            this.sex = sex;
        }
        // напишите тут ваши переменные и конструкторы
    }
}
