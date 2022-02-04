package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> keyWords = new ArrayList<>(Arrays.asList("user", "loser", "coder", "proger"));

        Person person = null;
        String key = null;
        do { key = reader.readLine();
            if (key.equals("user")) {
                doWork(new Person.User());
            } else if (key.equals("loser")) {
                doWork(new Person.Loser());
            } else if (key.equals("coder")) {
                doWork(new Person.Coder());
            } else if (key.equals("proger")) {
                doWork(new Person.Proger());
            }
        } while(keyWords.contains(key));
        //тут цикл по чтению ключей, пункт 1
        {
            //создаем объект, пункт 2

           // doWork(person); //вызываем doWork

        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
        else if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
        else if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
        else ((Person.User) person).live();// пункт 3
    }
}
