package com.javarush.task.task18.task1816;
/*
Английские буквы
В метод main первым параметром приходит имя файла.
Посчитать количество букв английского алфавита, которое есть в этом файле.
Вывести на экран число (количество букв).
Закрыть потоки.
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать буквы английского алфавита и вывести это число в консоль.
4. Нужно учитывать заглавные и строчные буквы.
5. Поток чтения из файла должен быть закрыт.
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static final String TEXT = "Мне очень нравится Тайланд. Таиланд это то место куда бы я поехал. тайланд - мечты сбываются!";

    public static void main(String[] args) throws Exception{
        //String fileName = args[0];
        //int cout = 0;

            //FileInputStream stream = new FileInputStream(fileName);
//            while (stream.available()>0) {
//                char c = (char)stream.read();
//                if (test(String.valueOf(c))) cout++;
//
//            }

//        System.out.println(cout);
//            stream.close();

        for (int i = 0; i < 360; i++) {
            if (test(String.valueOf((char) i))) System.out.print((char)i);
        }
        System.out.println(TEXT.replaceAll("[Тт]а[ий]ланд", "Украина"));
    }
    public  static boolean test(String c) {
        Pattern p = Pattern.compile("^[a-dm-p5-8]$");
        Matcher m = p.matcher(c);
        return m.matches();

    }


}
