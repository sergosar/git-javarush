package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) {
        //args = new String[]{"e:\\2.txt", "e:\\1.txt"};
        try(BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            BufferedWriter writer = new BufferedWriter(new FileWriter(args[1])) )
        {
            Pattern p = Pattern.compile("\\S*\\d+\\S*");
            while (reader.ready()) {
                String line = reader.readLine();
                Matcher m = p.matcher(line);
                while(m.find()) {
                    writer.write(m.group() + " ");
                    System.out.println(m.group());
                }
            }
        }catch (IOException e) {
        }
    }
}
