package com.javarush.task.task14.task1414;

/* 
MovieFactory
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> keyWords = new ArrayList<>(Arrays.asList("cartoon", "thriller", "soapOpera"));

        Movie movie = null;
        String key = null;
        while(true) {
            key = reader.readLine();
            movie= MovieFactory.getMovie(key);
            if (keyWords.contains(key)) {
                System.out.println(movie.getClass().getSimpleName());
            } else break;
        }


    }

    static class MovieFactory {
        static Movie getMovie(String key) {
            Movie movie = null;
            if ("soapOpera".equals(key)) {
                movie = new SoapOpera();
            } else if ("cartoon".equals(key)) {
                movie = new Cartoon();
            } else if ("thriller".equals(key)) {
                movie = new Thriller();
            }
            return movie;
        }
    }

    static abstract class Movie {
    }

    static class SoapOpera extends Movie {
    }

    static class Cartoon extends Movie {
    }

    static class Thriller extends Movie {
    }
    //Напишите тут ваши классы, пункт 3
}
