package com.javarush.task.task14.task1408;

/**
 * Created by SS on 12.09.2017.
 */
abstract class Hen {
    abstract  int getCountOfEggsPerMonth();
    String getDescription() {
        return "Я - курица.";
    }
}
