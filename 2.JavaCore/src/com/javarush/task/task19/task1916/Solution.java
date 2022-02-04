package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        String fileName1 = null;
        String fileName2 = null;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            fileName1 = reader.readLine();
            fileName2 = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        ArrayList<String> l1 = new ArrayList<>();
        ArrayList<String> l2 = new ArrayList<>();
        //System.out.println(l1.size());

        try (BufferedReader reader1 = new BufferedReader(new FileReader(fileName1));
             BufferedReader reader2 = new BufferedReader(new FileReader(fileName2))) {
            while (reader1.ready()) l1.add(reader1.readLine());
            while (reader2.ready()) l2.add(reader2.readLine());

        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String s : l1) {
            System.out.println(s);
        }
        for (String s: l2) {
            System.out.println(s);
        }
        do {
            if (l1.size() == 1 && l2.size() == 0) {
                lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                l1.remove(0);
                continue;

            } else if (l1.size() == 0 && l2.size() == 1) {
                lines.add(new LineItem(Type.ADDED, l2.get(0)));
                l2.remove(0);
                continue;

            } else if (l1.get(0).equals(l2.get(0))) {
                lines.add(new LineItem(Type.SAME, l1.get(0)));
                l1.remove(0);
                l2.remove(0);
                continue;
            } else if (l1.size() > 1 && l1.get(1).equals(l2.get(0))) {
                lines.add(new LineItem(Type.REMOVED, l1.get(0)));
                l1.remove(0);
                continue;
            } else if (l2.size() > 1 && l1.get(0).equals(l2.get(1))) {
                lines.add(new LineItem(Type.ADDED, l2.get(0)));
                l2.remove(0);
                continue;
            }

        } while (!(l1.size() == 0 && l2.size() == 0));

        for (int i = 0; i < lines.size(); i++) {
            System.out.println(lines.get(i).type + " " + lines.get(i).line);
        }


    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
