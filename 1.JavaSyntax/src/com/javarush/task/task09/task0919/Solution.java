package com.javarush.task.task09.task0919;
/* 
Деление на ноль
Создай метод public static void divisionByZero, в котором подели любое число на ноль и выведи на экран результат деления.
Оберни вызов метода divisionByZero в try..catch. Выведи стек-трейс исключения используя метод exception.printStackTrace()
Требования:
1. Метод divisionByZero должен содержать операцию деления любого числа на ноль.
2. Метод divisionByZero должен вызывать System.out.println или System.out.print.
3. Метод main должен содержать блок try..catch.
4. Метод main должен отлавливать исключения метода divisionByZero.
5. Программа должна выводить стек-трейс пойманого исключения.
*/

public class Solution {

    public static void main(String[] args) {
        try {
            divisionByZero();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void divisionByZero(){
        System.out.println(0/0);
    }
}
