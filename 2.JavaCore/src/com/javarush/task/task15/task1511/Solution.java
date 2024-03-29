package com.javarush.task.task15.task1511;

import java.io.Serializable;

/* 
Требования:
1. Интерфейс SpecificSerializable должен расширять(extends) интерфейс Serializable.
2. Класс JavaDev должен реализовывать интерфейс SepecificSerializable.
3. В коде не должно быть явного наследования от Object(extends Object).
4. Класс JuniorJavaDev не должен явно наследовать интерфейс SpecificSerializable.
*/

public class Solution {
    public static void main(String[] args) {
        JuniorJavaDev me = new JuniorJavaDev();
        System.out.println(me.askHubert("What do you think about level15.lesson06.task01?"));
        System.out.println(me.askZapp("When will be the next update?"));
    }

    public interface SpecificSerializable extends Serializable {
    }

    public static class JavaDev  implements SpecificSerializable {
        String answerQuestion(String question) {
            return String.format("I'll be thinking of [%s]", question);
        }
    }

    public static class JuniorJavaDev extends  JavaDev {
        JavaDev zapp = new JavaDev();
        JavaDev hubert = new JavaDev();

        String askZapp(String question) {
            return zapp.answerQuestion(question);
        }

        String askHubert(String question) {
            return hubert.answerQuestion(question);
        }
    }
}
