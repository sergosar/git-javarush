package com.javarush.task.task13.task1315;
/* 
Том, Джерри и Спайк
1. Создай классы Dog, Cat и Mouse.
2. Реализуй интерфейсы в добавленных классах, учитывая что:
— Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
— Мышь(Mouse) может передвигаться и может быть съедена.
— Собака(Dog) может передвигаться и съесть кого-то.
Требования:
1. Класс Cat должен быть объявлен внутри класса Solution.
2. Класс Dog должен быть объявлен внутри класса Solution.
3. Класс Mouse должен быть объявлен внутри класса Solution.
4. Кот(Cat) может передвигаться, может кого-то съесть и может быть сам съеден.
5. Мышь(Mouse) может передвигаться и может быть съедена.
6. Собака(Dog) может передвигаться и съесть кого-то.
*/

import java.io.*;

public class Solution {
    public static void main(String[] args)
    {
        InputStream inStream = null;
        try {
            inStream = new FileInputStream("d://source.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        OutputStream outStream = null;

        File a = new File( "d://result1.txt");
        File b = new File("d://Superdir//Super.txt");

       if (!b.getParentFile().mkdir()) try {
           throw new IOException("fail");
       } catch (IOException e) {
           e.printStackTrace();
       }
        try {
            a.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }


        try {
            outStream = new FileOutputStream("d://result.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            while (inStream.available() > 0)
            {
                int data = inStream.read(); //читаем один байт из потока для чтения
                outStream.write(data); //записываем прочитанный байт в другой поток.
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            inStream.close(); //закрываем потоки
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            outStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //System.out.println(a.delete());
    }
    //может двигаться
    public interface Movable {
        void move();
    }

    //может быть съеден
    public interface Eatable {
        void eaten();
    }

    //может кого-нибудь съесть
    public interface Eat {
        void eat();
    }
    public class Dog implements Movable, Eat {

        @Override
        public void move() {

        }

        @Override
        public void eat() {

        }
    }
    public class Cat implements Movable, Eatable, Eat {

        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }

        @Override
        public void eat() {

        }
    }
    public class Mouse implements Movable, Eatable {
        @Override
        public void move() {

        }

        @Override
        public void eaten() {

        }
    }
}