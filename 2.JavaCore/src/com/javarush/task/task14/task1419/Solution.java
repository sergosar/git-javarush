package com.javarush.task.task14.task1419;

import org.w3c.dom.events.EventException;
import sun.misc.ExtensionInstallationException;

import java.io.EOFException;
import java.io.InterruptedIOException;
import java.util.*;
import java.util.concurrent.ExecutionException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        Exception a1 = new InputMismatchException();
        Exception a2 =  new EmptyStackException();
         Exception a3 = new ArrayIndexOutOfBoundsException();
         Exception a4 = new IndexOutOfBoundsException();
         Exception a5 = new EmptyStackException();
         Exception a6 = new EOFException();
         Exception a7 = new ExtensionInstallationException("sadfas");
         Exception a8  = new NoSuchElementException();
         Exception a9 = new InterruptedIOException();
         Exception a0 = new IllegalAccessException();
        exceptions.add(a2); exceptions. add( a3);
        exceptions.add(a4);exceptions.add(a5);
        exceptions.add(a6);exceptions.add(a7);
        exceptions.add(a8);exceptions.add(a1);
        exceptions.add(a9);//exceptions.add(a0);

    }



}
