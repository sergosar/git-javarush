package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {

                }
            }
        });
        Thread thread2 = new Thread(new Thread()  {
            @Override
            public void run() {
                while (true) {
                    try {
                        this.sleep(0);
                    } catch (InterruptedException e) {
                        System.out.println("InterruptedException");
                    }
                }
            }
        });
        Thread thread3 = new Thread(new Thread()  {
            @Override
            public void run() {
                while (true) {
                    try {
                        System.out.println("Ура");
                        this.sleep(500);
                    } catch (InterruptedException e) {

                    }
                }
            }
        });

        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                BufferedReader reader = new BufferedReader( new InputStreamReader( System.in));
                String str;
                int sum=0;
                try {
                    while (!(str = reader.readLine()).equals("N")){
                        sum+=Integer.parseInt(str);

                    }
                    System.out.println(sum);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        threads.add(thread1);
        threads.add(thread2);
        threads.add(thread3);
        threads.add(new myThread());
        threads.add(thread5);

    }

    static class myThread extends Thread implements Message {
        @Override
        public void run() {
            while (true) {
                if (this.isInterrupted()) {

                    break;
                }

            }
        }

        @Override
        public void showWarning() {
            interrupt();
        }
    }

    public static void main(String[] args) {





    }

}