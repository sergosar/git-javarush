package com.javarush.task.task15.task1502;
/*
ООП - Наследование животных
1. Создать public static класс Goose(Гусь).
2. Создать public static класс Dragon(Дракон).
3. Унаследовать класс Goose от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
4. Унаследовать класс Dragon от BigAnimal или SmallAnimal, подумать, какой логически больше подходит.
5. В классах Goose и Dragon переопределить метод String getSize(), расширить видимость до максимальной.
6. В классе Goose метод getSize должен возвращать строку «Гусь маленький, » + [getSize родительского класса].
7. В классе Dragon метод getSize должен возвращать строку «Дракон большой, » + [getSize родительского класса].
Требования:
1. Класс Goose должен быть создан внутри класса Solution и быть статическим.
2. Класс Dragon должен быть создан внутри класса Solution и быть статическим.
3. Класс Goose должен быть потомком класса SmallAnimal.
4. Класс Dragon должен быть потомком класса BigAnimal.
5. В классе Goose должен быть переопределен метод getSize, который должен возвращать строку формата "Гусь маленький, " + [getSize родительского класса].
6. В классе Dragon должен быть переопределен метод getSize, который должен возвращать строку формата "Дракон большой, " + [getSize родительского класса].
7. Область видимости переопределенных методов getSize в классах Goose и Dragon должна быть расширена до максимальной.
*/

public class Solution {
    //добавьте классы Goose и Dragon тут

    public static void main(String[] args) {
        Goose g = new Goose();
        Dragon dragon = new Dragon();
        System.out.println(g.getSize());
        System.out.println(dragon.getSize());
    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }

    public static class Goose extends SmallAnimal {
        @Override
       public String getSize() {
            return "Гусь маленький, " + super.getSize();
        }
    }
    public static class Dragon extends BigAnimal{
        @Override
        public String getSize() {
            return "Дракон большой, "+ super.getSize();
        }
    }

}
