package com.javarush.task.task13.task1309;
/* 
Всё, что движется
1. Создай интерфейс Movable с методом speed.
2. Метод speed должен возвращать значение типа Double и не должен ничего принимать в качестве аргументов.
3. Создай и унаследуй интерфейс Flyable от интерфейса Movable.
4. Добавь в интерфейс Flyable метод speed.
5. Метод speed должен возвращать значение типа Double и принимать один параметр типа Flyable.
Требования:
1. В классе Solution должен быть объявлен интерфейс Movable.
2. В классе Solution должен быть объявлен интерфейс Flyable.
3. Интерфейс Flyable должен наследоваться от интерфейса Movable.
4. В интерфейсе Movable должен быть объявлен метод speed без параметров и с типом возвращаемого значения Double.
5. В интерфейсе Flyable должен быть объявлен метод speed c одним аргументом типа Flyable и с
типом возвращаемого значения Double.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
    }
    interface Movable {
        Double speed();
    }
    interface Flyable extends Movable{


        Double speed(Flyable flyable);
    }
}