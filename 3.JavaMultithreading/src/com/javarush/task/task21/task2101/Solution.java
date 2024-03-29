package com.javarush.task.task21.task2101;

import java.util.BitSet;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
//        System.out.println(ip[0]);
//        System.out.println(mask[0]);
        byte[] netAddress = getNetAddress(ip, mask);

        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
      // System.out.println(Integer.toBinaryString(ip[0]));
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] netAddress = new byte[4];
        for (int i = 0 ; i < 4; i++ ) {
            netAddress[i] = (byte)(ip[i] & mask[i]);
        }

        return netAddress;
    }

    public static void print(byte[] bytes) {
       for (byte b: bytes) {
           System.out.print(Integer.toBinaryString((b & 0xFF) + 0x100).substring(1)+ " ");

       }
        System.out.println();


    }
}
