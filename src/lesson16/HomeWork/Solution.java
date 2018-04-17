package lesson16.HomeWork;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "bla bla bla";
        String[] results = test.split("");

        for (String result: results) {
            System.out.print(Arrays.toString(result.getBytes()));
        }

//        byte[] numbers = new byte[results.length];
//
//        for (int i = 0; i <results.length; i++) {
//            numbers[i] =
//        }


    }

    static int countWords(String input){

        String[] results = input.split(" ");

//        for (String result: results) {
//            byte[] numbers = result.getBytes();
//        }


        int count = 0;

        for (String result: results) {
            if (result != null && !result.equals("")) count++;
        }

        return count;

    }




}
