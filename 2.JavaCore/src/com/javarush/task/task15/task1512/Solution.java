package com.javarush.task.task15.task1512;

/* 
Требования:
1. Класс NormalCat должен быть потомком класса NakedCat.
2. Класс SiamCat должен быть потомком класса NormalCat.
3. В классе NakedCat не должно быть явно реализованных конструкторов без параметров.
4. В конструкторе без параметров класса NormalCat не должно быть явного вызова конструктора родительского класса.
*/

public class Solution {
    public static void main(String[] args) {
        SiamCat simka = new SiamCat("Simka");
        NakedCat nakedSimka = simka.shave();
    }

    public static class NakedCat {

    }

    public static class NormalCat extends NakedCat {


        public NormalCat(String name) {
            System.out.println("My name is " + name);
        }

        public NakedCat shave() {
            return this;
        }
    }

    public static class SiamCat extends NormalCat {
        public SiamCat(String name) {
            super(name);
        }
    }
}
