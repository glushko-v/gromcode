package lesson32.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.Scanner;


public class Solution {

    static void readNumbers() throws IOException {


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String s = br.readLine();


        String[] array = s.split(" ");
        int[] digits = stringToDigits(array);



        for (int i = 0; i < 2; i++) {

            if (digits.length != 10) {

                System.out.println("Wrong");
                s = br.readLine();
                array = s.split(" ");

                if (i == 1) {

                    throw new IOException("Your numbers are wrong");
                }
            } else break;
        }


        br.close();

        System.out.println(sumOfDigits(stringToDigits(array)));


    }

    private static int[] stringToDigits(String[] array) {


        int[] digits = new int[array.length];

        for (int i = 0; i < array.length; i++) {


            char[] syms = array[i].toCharArray();
            for (char sym : syms) {
                if (!Character.isDigit(sym)) {
                    System.out.println("Error");
                    break;

                } else {
                    digits[i] = Integer.parseInt(array[i]);
                }

            }


        }

        return digits;
    }

    private static int sumOfDigits(int[] digits) {
        int sum = 0;

        for (int i = 0; i < digits.length; i++) {
            sum += digits[i];
        }


        return sum;
    }

//    private static boolean validateDigits(int[] digits) {
//
//        for (int i = 0; i <digits.length ; i++) {
//
//            if (digits[i] > 99) {
//                return false;
//            }
//
//        }
//
//        return true;
//
//    }


}



