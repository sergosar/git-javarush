package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Pattern;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) {


        String[] s = args;

     if (s[0].equals("-c")) {      //-c name sex bd
            if (s[2].equals("м")) {
                try {
                    allPeople.add(Person.createMale(s[1], new SimpleDateFormat("dd/MM/yyyy").parse
                            (s[3])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else try {
                allPeople.add(Person.createFemale(s[1], new SimpleDateFormat("dd/MM/yyyy").parse
                        (s[3])));
            } catch (ParseException e) {
                e.printStackTrace();
            }
         System.out.println(allPeople.size()-1);

        } else if (s[0].equals("-u")) {     //-u id name sex bd
            if (s[3].equals("м")) {
                try {
                    allPeople.set(Integer.parseInt(s[1]),Person.createMale(s[2], new SimpleDateFormat("dd/MM/yyyy").parse
                            (s[4])));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }else try {
                allPeople.set(Integer.parseInt(s[1]),Person.createFemale(s[2], new SimpleDateFormat("dd/MM/yyyy").parse
                        (s[4])));
            } catch (ParseException e) {
                e.printStackTrace();
            }


        } else if (s[0].equals("-d")) { //-d id
            Person p = allPeople.get(Integer.parseInt(s[1]));
            p.setBirthDay(null);
            p.setName(null);
            p.setSex(null);

        } else if(s[0].equals("-i")) {
            Person person = allPeople.get(Integer.parseInt(s[1]));
            System.out.print(person.getName() + " ");
            if (person.getSex().equals(Sex.FEMALE)) System.out.print("ж ");
            else System.out.print("м ");
            System.out.print(new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH).format(person.getBirthDay()));

        }

        //for (String c : s ) System.out.println(c);


    }
}
