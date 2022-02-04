package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties properties1 = new Properties();

    public void fillInPropertiesMap() throws Exception {
        String fileName = null;

        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            fileName = reader.readLine();//implement this method - реализуйте этот метод
        } catch (IOException e) {

        }
        FileInputStream fileInputStream = new FileInputStream(fileName);
        load(fileInputStream);


    }

    public void save(OutputStream outputStream) throws Exception {
//        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
//        StringBuilder sb = new StringBuilder();
//        for (Map.Entry<String , String> entry : properties.entrySet()) {
//            sb.append(entry.getKey()).append(":").append(entry.getValue());
//            writer.write(sb.toString()); writer.newLine();
//            sb.setLength(0);//implement this method - реализуйте этот метод
//        }
        properties1.clear();
        properties1.putAll(properties);
        properties1.store(outputStream,"");
    }

    public void load(InputStream inputStream) throws Exception {
        properties1.load(inputStream);
        for (Object o : properties1.keySet()){
            String key = (String) o;
            String value =properties1.getProperty(key);
            properties.put(key, value);
        }//implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {

    }
}
