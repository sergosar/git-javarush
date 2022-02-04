package com.javarush.task.task20.task2026;

import java.util.ArrayList;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a0 = new byte[][]{
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 1, 0},
                {1, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0},
                {0, 0, 0, 1, 0, 0},
                {1, 1, 0, 1, 0, 1}

        };
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };

        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        int count1 = getRectangleCount(a1);
        System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        System.out.println(getRectangleCount(a0));
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        int length = a.length;
        for (int x = 0; x < length; x++) {
            for (int y = 0; y < length; y++) {
                if (a[x][y] == 1) {
                    count++;
                    convert(a, x, y);
                }
            }
        }

        return count;
    }

    public static void convert(byte[][] a, int x, int y) {
        int length = a.length - 1;
        ArrayList<Coord> coords = new ArrayList<>();
        a[x][y] = 0;
        if (x < length) {
            newCoord(a, coords, x + 1, y);
            if (y < length) {
                newCoord(a, coords, x + 1, y + 1);
                newCoord(a, coords, x, y + 1);
            }
        } else if (y < length) newCoord(a, coords, x, y + 1);
        for (Coord coord : coords) {
            convert(a, coord.getX(), coord.getY());
        }

    }

    public static class Coord {
        private int x;
        private int y;

        public Coord(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public void setX(int x) {
            this.x = x;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }
    }

    public static void newCoord(byte[][] a, ArrayList<Coord> coords, int x, int y) {
        if (a[x][y] == 1) coords.add(new Coord(x, y));
    }
}
