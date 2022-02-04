package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {
        String fileName = null;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            while (reader.ready()) {
                stringBuilder.append(reader.readLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fullS = stringBuilder.toString();
        String tagStart = "<" + args[0];
        String tagEnd = "</" + args[0] + ">";
        int pos = 0;
        int depth = 0;
        for (int indexStart = fullS.indexOf(tagStart); indexStart > -1; ) {
            depth++;
            pos = indexStart;
            while (depth != 0) {
                pos += tagStart.length();
                if (fullS.indexOf(tagStart, pos) != -1 && fullS.indexOf(tagStart, pos) < fullS.indexOf(tagEnd, pos)) {
                    pos = fullS.indexOf(tagStart, pos);
                    depth++;
                } else {
                    pos = fullS.indexOf(tagEnd, pos);
                    depth--;
                }
            }
            System.out.println(fullS.substring(indexStart, pos + tagEnd.length()));
            fullS = fullS.substring(indexStart+1);
            indexStart = fullS.indexOf(tagStart);
        }
    }
}
