package lesson32.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;


public class Solution {

    static void readNumbers() throws IOException {

        //проверка на длину массива++
        //проверка на длину цифры


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String s = br.readLine();

        String[] array = s.split(" ");

        for (int i = 0; i < 2; i++) {
            if (array.length <= 9) {
                System.out.println("Wrong");
                s = br.readLine();
                array = s.split(" ");
                if (i == 1) {
                    System.out.println("Nope");
                    throw new IOException("Your numbers are wrong");
                }
            } else break;
        }


        int[] digits = new int[array.length];
        int sum = 0;


        for (int i = 0; i < array.length; i++) {


            digits[i] = Integer.parseInt(array[i]);
            sum += digits[i];


        }


        System.out.println(Arrays.toString(digits));
        System.out.println(sum);


    }
}



