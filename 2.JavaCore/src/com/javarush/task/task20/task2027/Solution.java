package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        //detectAllWords(crossword, "home", "same");
        for (Word w: detectAllWords(crossword, "home", "same")){
            System.out.println(w.toString());
        }


        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<char []> arrayWordsChar = new ArrayList<>();
        for (String s : words) {
            arrayWordsChar.add(s.toCharArray());
        }
        ArrayList<int []> arrayWords  = new ArrayList<>();
        List<Word> wordList = new ArrayList<>();
        int k = 0;
        int length1 = crossword.length;
        int length2 = crossword[0].length;


        for (char [] a : arrayWordsChar) {
            arrayWords.add(new int[a.length]);
                    for(int i = 0 ; i < a.length; i++) {
                arrayWords.get(k)[i] = a[i];
                    }
                    k++;
        }


        Vector[] vectors = {new Vector(1, 0),
        new Vector(-1, 0),
        new Vector(0, 1),
        new Vector(0, -1),
        new Vector(1,1),
        new Vector(-1, -1),
        new Vector(1, -1),
        new Vector(-1,1)};

        for (int x = 0; x < crossword.length; x++) {
            for (int y = 0; y < crossword[0].length; y++) {
                for (int[] wordsAr : arrayWords) {
                    if(crossword[x][y] == wordsAr[0]){
                        for (Vector v: vectors) {
                            if (find(crossword, x, y, v, wordsAr, length1, length2)) {
                                StringBuilder sb = new StringBuilder();
                                for (int z : wordsAr) {
                                    sb.append((char)z);
                                }
                                Word word = new Word(sb.toString());
                                word.setStartPoint(y,x);
                                word.setEndPoint(y + v.y*(wordsAr.length-1),x+v.x*(wordsAr.length-1));
                                wordList.add(word);

                            }
                        }
                    }

                }

            }
        }


        return wordList;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
    public  static class Vector {
        int x,  y;

        public Vector(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static boolean find(int[][] cros, int x, int y, Vector v, int[]  w, int length1, int length2 ) {
        for (int i = 0 ; i < w.length; i++ ) {
            if (x + v.x *i< length1 && y + v.y *i< length2 && x + v.x *i> -1 && y + v.y *i> -1) {
                if (cros[x + v.x*i][y + v.y*i] == w[i]) {
                    if (i == w.length-1) return true;
                } else return false;
            } else return false;
        }
        return false;
    }


}
