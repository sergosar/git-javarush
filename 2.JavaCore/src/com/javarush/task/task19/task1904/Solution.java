package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            String[] personS = fileScanner.nextLine().split(" ");
            Date birthDate = new Date(Integer.parseInt(personS[5])- 1900, Integer.parseInt(personS[4])-1,
                    Integer.parseInt(personS[3]));
            Person person = new Person(personS[1], personS[2], personS[0], birthDate);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
