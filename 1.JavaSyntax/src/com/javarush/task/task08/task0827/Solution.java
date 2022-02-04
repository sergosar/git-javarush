package com.javarush.task.task08.task0827;
import java.util.Date;
/* 
1. Реализовать метод isDateOdd(String date) так, чтобы он возвращал true, если количество дней с начала года — нечетное число, иначе false
2. String date передается в формате MAY 1 2013
Не забудьте учесть первый день года.
Пример:
JANUARY 1 2000 = true
JANUARY 2 2020 = false
Требования:
1. Программа должна выводить текст на экран.
2. Класс Solution должен содержать два метода.
3. Метод isDateOdd() должен возвращать true, если количество дней с начала года - нечетное число, иначе false.
4. Метод main() должен вызывать метод isDateOdd().
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    } //MAY 1

    public static boolean isDateOdd(String date) {
        Date date1 = new Date(date);
        Date date2 = new Date("JANUARY 1 " + (date1.getYear()+1900) );
        long time = date1.getTime()- date2.getTime();
        long day = 24*60*60*1000;
//        System.out.println(time);
//        System.out.println(day);
//        System.out.println(time/day);
//        System.out.println(date2);
        boolean odd = (time/day)%2 == 0;

        return odd;
    }
}
