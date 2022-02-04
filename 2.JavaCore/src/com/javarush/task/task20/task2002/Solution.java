package com.javarush.task.task20.task2002;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("e:\\1", "txt");
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Rubi");
            user.setLastName("Rail");
            user.setBirthDate(new Date(1508944516168L));
            user.setMale(true);
            user.setCountry(User.Country.OTHER);

            User user1 = new User();
            user1.setFirstName("Vasa1");
            user1.setLastName("Peta1");
            user1.setBirthDate(new Date(1508944516163L));
            user1.setMale(true);
            user1.setCountry(User.Country.RUSSIA);

            User user3 = new User();
            user3.setFirstName("Solo");
            user3.setLastName("Han");
            user3.setBirthDate(new Date(1508944516169L));
            user3.setMale(true);
            user3.setCountry(User.Country.UKRAINE);
            javaRush.users.add(user);
            javaRush.users.add(user1);
            javaRush.users.add(user3);//initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            if (javaRush.equals(loadedObject)) System.out.println(true);
            else
                System.out.println(false);//check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream))) {
                if (this.users.size()==0) {writer.write("zero");
                writer.newLine();
                } else {
                    writer.write("not zero"); writer.newLine();

                    for (int i = 0 ; i < this.users.size(); i++) {

                        writer.write(users.get(i).getFirstName()+ " ");
                        writer.write(users.get(i).getLastName()+ " ");
                        writer.write(users.get(i).getBirthDate().getTime()+ " ");
                        writer.write(users.get(i).isMale()+ " ");
                        writer.write(users.get(i).getCountry().toString()+ " ");

                        //System.out.println(users.get(i).getCountry().getDisplayedName());
                        writer.newLine();
                    }
                }


                //implement this method - реализуйте этот метод
            }
        }

        public void load(InputStream inputStream) throws Exception {
            try(BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                if (reader.readLine().equals("zero")) return;
                else { while (reader.ready()) {

                    User user = new User();
                    String[] strings = reader.readLine().split(" ");
                    user.setFirstName(strings[0]);
                    user.setLastName(strings[1]);
                    user.setBirthDate(new Date(Long.parseLong(strings[2])));
                    user.setMale(Boolean.parseBoolean(strings[3]));
                    //System.out.println(strings[4]);
                    user.setCountry(User.Country.valueOf(strings[4]));
                    this.users.add(user);



                }

                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
