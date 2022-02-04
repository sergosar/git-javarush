package com.javarush.task.task20.task2025;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by SS on 17.04.2018.
 */
public class B {
    private static long[][] pows;
    public static void main(String[] args) {
        genPows(2);
        for (int i = 0; i < pows.length; i ++){
            for (int j = 0 ; j < pows[i].length; j++) {
                System.out.print(i+ "," + j + " " + pows[i][j]+ " |");
            }
            System.out.println();
        }

        Exception exception = new Exception() {
            int s;

        };

    }
    private static void genPows(int N) {
        if (N > 20) throw new IllegalArgumentException();
        pows = new long[10][N + 1];
        for (int i = 0; i < pows.length; i++) {
            long p = 1;
            for (int j = 0; j < pows[i].length; j++) {
                pows[i][j] = p;
                p *= i;
            }
        }
    }
}
