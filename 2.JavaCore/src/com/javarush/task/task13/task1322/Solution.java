package com.javarush.task.task13.task1322;
/* 
Интерфейс SimpleObject
1. Создай класс StringObject.
2. В классе StringObject реализуй интерфейс SimpleObject с параметром типа String.
3. Программа должна компилироваться.
Требования:
1. Класс StringObject должен реализовывать интерфейс SimpleObject.
2. Интерфейс SimpleObject в классе StringObject должен быть реализован с параметром типа String.
3. В классе StringObject реализовать метод getInstance интерфейса SimpleObject.
4. Класс StringObject должен существовать в классе Solution.
5. Класс StringObject должен быть статическим.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }
    static class StringObject<Object> implements SimpleObject {

        @Override
        public SimpleObject<String> getInstance() {
            return this;
        }
    }
}
