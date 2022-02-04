package com.javarush.task.task12.task1207;
/* nt и Integer
Написать два метода: print(int) и print(Integer).
Написать такой код в методе main, чтобы вызвались они оба.


Требования:
1. Класс Solution должен содержать статический метод main().
2. Класс Solution должен содержать статический метод print() с параметром типа int.
3. Класс Solution должен содержать статический метод print() с параметром типа Integer.
4. Метод main() должен вызывать метод print() с параметром типа int.
5. Метод main() должен вызывать метод print() с параметром типа Integer.
*/

public class Solution {
    public static void main(String[] args) {
        int i = 5;
        Integer i2 = Integer.valueOf(5);
        print(i =7);
        print(i2 = 8);
    }
    public static void print(int i) {
        System.out.println(i);

    }
    public static void print(Integer i) {
        System.out.println(i);
    }
    //Напишите тут ваши методы
}
