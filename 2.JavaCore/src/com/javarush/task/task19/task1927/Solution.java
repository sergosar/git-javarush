package com.javarush.task.task19.task1927;

/* 
Контекстная реклама
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        String s =  "JavaRush - курсы Java онлайн";
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();

        System.setOut(consoleStream);

        String string = outputStream.toString();
        Pattern p = Pattern.compile("\n");
        Matcher m = p.matcher(string);
        StringBuffer sb = new StringBuffer();

        int i = 0;
        while (m.find()) {
            i++;
            if (i%2==0){
                m.appendReplacement(sb , m.group() + s + "\n" );
            }

        }
        m.appendTail(sb);
        System.out.println(sb.toString());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("first");
            System.out.println("second");
            System.out.println("third");
            System.out.println("fourth");
            System.out.println("fifth");
        }
    }
}
