package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        if(n < 0) return "0";
        if (n == 0) return "1";
        BigInteger fact = BigInteger.valueOf(1);
        for (int c = 1; c < n+1 ; c ++ ) {
            fact= fact.multiply(BigInteger.valueOf(c));//add your code here
        }

        return fact.toString();
    }
}
