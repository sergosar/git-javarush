package com.javarush.task.task12.task1220;
/* 
Класс Human и интерфейсы Run, Swim
Напиши public класс Human(человек) и public интерфейсы Run(бежать/ездить), Swim(плавать).
Добавь в каждый интерфейс по одному методу.
Добавь эти интерфейсы классу Human, но не реализуй методы.
Объяви класс Human абстрактным.
Требования:
1. Класс Solution должен содержать интерфейс Run с одним методом.
2. Класс Solution должен содержать интерфейс Swim с одним методом.
3. Класс Solution должен содержать класс Human.
4. Класс Human должен реализовывать интерфейсы Run и Swim.
5. Класс Human должен быть абстрактным.
6. Класс Human не должен иметь методов.
*/

public class Solution {
    public static void main(String[] args) {

    }
    public abstract class Human implements Swim, Run {}
    public interface Run {
        public void run();
    }
    public interface Swim {
        public void swim();
    }
    //add public interfaces and public class here - добавь public интерфейсы и public класс тут
}
