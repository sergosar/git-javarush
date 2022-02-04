package com.javarush.task.task18.task1821;
/*
Встречаемость символов
Программа запускается с одним параметром - именем файла, который содержит английский текст.
Посчитать частоту встречания каждого символа.
Отсортировать результат по возрастанию кода ASCII (почитать в инете).
Пример:
','=44, 's'=115, 't'=116.
Вывести на консоль отсортированный результат:
[символ1] частота1
[символ2] частота2
Закрыть потоки.
Пример вывода:
, 19
- 7
f 361
Требования:
1. Считывать с консоли ничего не нужно.
2. Создай поток для чтения из файла, который приходит первым параметром в main.
3. В файле необходимо посчитать частоту встречания каждого символа и вывести результат.
4. Выведенный в консоль результат должен быть отсортирован по возрастанию кода ASCII.
5. Поток для чтения из файла должен быть закрыт.
*/


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws Exception {
        //System.out.println(args[0]);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(args[0])));
        TreeMap<Integer, Integer> symbols = new TreeMap<>();
        while (reader.ready()) {
            int c = reader.read();
            if (symbols.containsKey(c)) symbols.put(c, symbols.get(c) + 1);
            else symbols.put(c, 1);
        }
        for (Map.Entry<Integer, Integer> e : symbols.entrySet()) {

            System.out.println((char) (int) e.getKey() + " " + e.getValue());
        }
        reader.close();


    }

    public static class Symbol {
        int number;
        int frequency = 0;

        public Symbol(int number) {
            this.number = number;

        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Symbol)) return false;

            Symbol symbol = (Symbol) o;

            return number == symbol.number;
        }

        @Override
        public int hashCode() {
            return number;
        }
    }
}
