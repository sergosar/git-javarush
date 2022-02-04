package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {
        String[] s = args;
        switch (args[0]) {

            case "-c": {
                synchronized (allPeople) {//-c name1 sex1 bd1 name2 sex2 bd2 ...
                for (int i = 1; i < s.length; i += 3) {

                    if (s[i + 1].equals("м")) {
                        try {
                            allPeople.add(Person.createMale(s[i], new SimpleDateFormat("dd/MM/yyyy").parse
                                    (s[i + 2])));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else try {
                        allPeople.add(Person.createFemale(s[i], new SimpleDateFormat("dd/MM/yyyy").parse
                                (s[i + 2])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    System.out.println(allPeople.size() - 1);
                }
                break;
            }}

            case "-u": {
                synchronized (allPeople){//-u id1 name1 sex1 bd1 id2 name2 sex2 bd2 ...
                for (int i = 1; i < s.length; i += 4) {

                    if (s[i + 2].equals("м")) {
                        try {
                            allPeople.set(Integer.parseInt(s[i]), Person.createMale(s[i + 1], new SimpleDateFormat("dd/MM/yyyy").parse
                                    (s[i + 3])));
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else try {
                        allPeople.set(Integer.parseInt(s[i]), Person.createFemale(s[i + 1], new SimpleDateFormat("dd/MM/yyyy").parse
                                (s[i + 3])));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }}
            case "-d": {
                synchronized (allPeople) {//-d id
                for (int i = 1; i < s.length; i++) {
                    Person p = allPeople.get(Integer.parseInt(s[i]));
                    p.setBirthDay(null);
                    p.setName(null);
                    p.setSex(null);
                }
                break;
            }}
            case "-i": {
                synchronized (allPeople){//-i id1 id2 id3 id4 ...
                for (int i = 1; i < s.length; i++) {
                    Person person = allPeople.get(Integer.parseInt(s[i]));
                    System.out.print(person.getName() + " ");
                    if (person.getSex().equals(Sex.FEMALE)) System.out.print("ж ");
                    else System.out.print("м ");
                    System.out.print(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));
                    System.out.println();
                }
            }}
        }
//        System.out.println(" -------------");
//        for (Person p : allPeople) {
//            System.out.println(1);
//           printPerson(p); //start here - начни тут}
//        }
    }

    public static void printPerson(Person p) {
        System.out.println(p.getName() + " " + p.getSex() + " " + p.getBirthDay());
    }
}
