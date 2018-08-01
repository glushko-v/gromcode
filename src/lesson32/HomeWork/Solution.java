package lesson32.HomeWork;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {

    static void readNumbers() throws IOException {

        //1. получаем массив стрингов
        //2. проверяем каждый элемент массива стрингов - цифра или нет


        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String s = br.readLine();


        String[] array = s.split(" ");



        for (int i = 0; i < 2; i++) {
            int[] digits = stringToDigits(array);


            if (digits.length != 10 || !validateDigits(digits)) {

                System.out.println("Wrong");
                s = br.readLine();
                array = s.split(" ");


                if (i == 1) {

                    System.out.println("Your numbers are wrong");
                    break;
                }
            } else {
                System.out.println(sumOfDigits(stringToDigits(array)));
                break;
            }
        }


        br.close();


    }

    static int[] stringToDigits(String[] array) {


        int[] digits = new int[array.length];


        for (int i = 0; i < array.length; i++) {

            if (!isDigit(array[i])) {
                System.out.println("Error");
                break;



            } else digits[i] = Integer.parseInt(array[i]);


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

    static boolean isDigit(String word) {

        char[] syms = word.toCharArray();

        for (int i = 0; i < syms.length; i++) {
            if (!Character.isDigit(syms[i])) {
                return false;
            }
        }

        return true;
    }

    static boolean validateDigits(int[] digits) {

        for (int i = 0; i < digits.length; i++) {
            if (digits[i] > 100) return false;

        }
        return true;
    }


}



