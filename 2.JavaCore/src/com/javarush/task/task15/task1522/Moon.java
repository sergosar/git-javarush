package com.javarush.task.task15.task1522;

/**
 * Created by SS on 19.10.2017.
 */
public class Moon implements Planet {
    private static Moon instance ;

    public static Moon getInstance() {
        if (instance == null) instance = new Moon();
        return instance;
    }

    private Moon() {
    }
}
