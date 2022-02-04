package com.javarush.task.task14.task1408;

/**
 * Created by SS on 12.09.2017.
 */
public class MoldovanHen extends Hen {
    @Override
    int getCountOfEggsPerMonth() {
        return 0;
    }
    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.MOLDOVA + ". Я несу " + this.getCountOfEggsPerMonth()+ " яиц в месяц.";
    }
}
