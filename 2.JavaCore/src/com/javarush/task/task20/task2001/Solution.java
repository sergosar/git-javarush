package com.javarush.task.task20.task2001;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Читаем и пишем в файл: Human
Реализуй логику записи в файл и чтения из файла для класса Human.
Поле name в классе Human не может быть пустым.
Метод main реализован только для вас и не участвует в тестировании.
Требования:
1. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если список assets пустой.
2. Логика чтения/записи реализованная в методах save/load должна работать корректно в случае, если поле name и список assets не пустые.
3. Класс Solution.Human не должен поддерживать интерфейс Serializable.
4. Класс Solution.Human должен быть публичным.
5. Класс Solution.Human не должен поддерживать интерфейс Externalizable.
*/
public class Solution {
    public static void main(String[] args) {
        //исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("e:\\1.txt", null);
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            Human ivanov = new Human("Ivanov", new Asset("home", 999_999.99), new Asset("car", 2999.99));
            ivanov.save(outputStream);
            outputStream.flush();


            Human somePerson = new Human();
            somePerson.load(inputStream);
            inputStream.close();
            System.out.println(ivanov.equals(somePerson));//check here that ivanov equals to somePerson - проверьте тут, что ivanov и somePerson равны
            System.out.println(System.getProperty("java.io.tmpdir"));



        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
        String testName = null;
        try(BufferedWriter writer = new BufferedWriter(new FileWriter("e:\\1.txt"))){
        writer.write(testName);} catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static class Human {
        public String name;
        public List<Asset> assets = new ArrayList<>();

        public Human() {
        }

        public Human(String name, Asset... assets) {
            this.name = name;
            if (assets != null) {
                this.assets.addAll(Arrays.asList(assets));
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Human human = (Human) o;

            if (name != null ? !name.equals(human.name) : human.name != null) return false;
            return assets != null ? assets.equals(human.assets) : human.assets == null;
        }

        @Override
        public int hashCode() {
            int result = name != null ? name.hashCode() : 0;
            result = 31 * result + (assets != null ? assets.hashCode() : 0);
            return result;
        }

        public void save(OutputStream outputStream) throws Exception {
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                writer.write(this.name);
                writer.newLine();
                if (assets.size() != 0) {
                    for (Asset a : assets) {
                        writer.write(a.getName()); writer.newLine();
                        writer.write(Double.toString(a.getPrice())); writer.newLine();
                    }
                } else writer.write("null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                this.name = reader.readLine();
                String line = null;
                line= reader.readLine();
                if (line.equals("null")) return;
                else {
                    this.assets.add(new Asset(line, Double.parseDouble(reader.readLine())));
                }
                while (reader.ready()) {
                    this.assets.add(new Asset(reader.readLine(), Double.parseDouble(reader.readLine())));
                }
            }
            //implement this method - реализуйте этот метод
        }
    }
}
