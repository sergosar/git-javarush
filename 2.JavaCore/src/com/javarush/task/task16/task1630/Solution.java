package com.javarush.task.task16.task1630;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.util.List;

public class  Solution {
    public static String firstFileName;
    public static String secondFileName;

    static { BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = bufferedReader.readLine();
            secondFileName = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread  extends Thread implements ReadFileInterface {
        FileReader fileReader ;
        StringBuilder str = new StringBuilder();
        //File file;


        @Override
        public void setFileName(String fullFileName) {


            try {
                fileReader = new FileReader(fullFileName);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }

        @Override
        public String getFileContent() {


            return str.toString();
        }


        @Override
        public void run() {
            BufferedReader reader = new BufferedReader(fileReader);
            try {
                while (reader.ready()) {
                    str.append(reader.readLine()+ " ");
                }
                reader.close();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }//add your code here - добавьте код тут
}
