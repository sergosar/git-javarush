package com.javarush.task.task08.task0824;

import java.util.ArrayList;
import java.util.Arrays;

/*Собираем семейство
1. Создай класс Human с полями имя (String), пол (boolean), возраст (int), дети (ArrayList<Human>).
2. Создай объекты и заполни их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
3. Вывести все объекты Human на экран.
Требования:
1. Программа должна выводить текст на экран.
2. Класс Human должен содержать четыре поля.
3. Класс Human должен содержать один метод.
4. Класс Solution должен содержать один метод.
5. Программа должна создавать объекты и заполнять их так, чтобы получилось: два дедушки, две бабушки, отец, мать, трое детей.
*/
public class Solution {
    public static void main(String[] args) {
        Human child1 = new Human("child1" , true, 1);
        Human child2 = new Human("child2", false, 0);
        Human child3 = new Human("child3", false, 0);

        Human father = new Human("father", true, 2, new ArrayList<Human>(Arrays.asList(child1, child2, child3)));
        Human mother = new Human("mother", false, 2, new ArrayList<Human>(Arrays.asList(child1, child2, child3)));

        Human gf1 = new Human("father", true, 2, new ArrayList<Human>(Arrays.asList(father)));
        Human gm1 = new Human("father", false, 2, new ArrayList<Human>(Arrays.asList(father)));

        Human gf2 = new Human("father", true, 2, new ArrayList<Human>(Arrays.asList(mother)));
        Human gm2 = new Human("father", false, 2, new ArrayList<Human>(Arrays.asList(mother)));

        System.out.println(child1.toString());
        System.out.println(child2.toString());
        System.out.println(child3.toString());
        System.out.println(father.toString());
        System.out.println(mother.toString());
        System.out.println(gf1.toString());
        System.out.println(gm1.toString());
        System.out.println(gf2.toString());
        System.out.println(gm2.toString());

        //напишите тут ваш код
    }

    public static class Human {
        String name;
        boolean sex;
        int age;
        ArrayList<Human> children;

        public Human(String name, boolean sex, int age, ArrayList<Human> children) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = children;
        }

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
            this.children = new ArrayList<>();
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
