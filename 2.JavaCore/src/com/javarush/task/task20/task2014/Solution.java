package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) {
        Solution savedObject =new Solution(20);
        try(
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("e:\\1.txt")))
        {
        objectOutputStream.writeObject(savedObject);
        objectOutputStream.close();
        }catch (IOException e) {
            e.printStackTrace();
        }
        Solution loadedObject = new Solution(15);
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("e:\\1.txt"))) {
            loadedObject = (Solution)objectInputStream.readObject();
            System.out.println(savedObject.string.equals(loadedObject.string));
            objectInputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {

        }

        System.out.println(new Solution(4));
    }

    transient private final String pattern = "dd MMMM yyyy, EEEE";
    transient private Date currentDate;
    transient private int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
