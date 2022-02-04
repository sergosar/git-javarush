package com.javarush.task.task20.task2015;
import java.io.*;
import java.util.Scanner;
/*
Переопределение сериализации
Сделайте так, чтобы после десериализации нить runner продолжила работать.
Ключевые слова объекта runner менять нельзя.
Hint/Подсказка:
Конструктор не вызывается при десериализации, только инициализируются все поля.

Требования:
1. Класс Solution должен поддерживать интерфейс Serializable.
2. Класс Solution должен поддерживать интерфейс Runnable.
3. Поле runner в классе Solution должно быть объявлено с модификатором transient.
4. В методе readObject должен быть создан новый объект типа Thread с текущим объектом в качестве параметра.
5. В методе readObject должен быть вызван метод start у нового объекта типа Thread.
*/
public class Solution implements Serializable, Runnable{
    transient private Thread runner;
    private int speed;

    public Solution(int speed) {
        this.speed = speed;
        runner = new Thread(this);
        runner.start();
    }

    public void run() {

        int i = 0;
        while(true) {
            System.out.println(i++);
            try {
                wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    /**
     Переопределяем сериализацию.
     Для этого необходимо объявить методы:
     private void writeObject(ObjectOutputStream out) throws IOException
     private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException
     Теперь сериализация/десериализация пойдет по нашему сценарию :)
     */
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        Thread thread = new Thread(this);
        thread.start();

    }

    public static void main(String[] args) {
        Solution savedObject =new Solution(20);
        savedObject.run();
        try(
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\1.txt")))
        {
            objectOutputStream.writeObject(savedObject);
            objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }

        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\1.txt"))) {
            savedObject = (Solution)objectInputStream.readObject();

            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

    }
}
