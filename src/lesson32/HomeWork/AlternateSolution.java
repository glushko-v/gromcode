package lesson32.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class AlternateSolution {


    static void readNumbers() throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);
        int sum = 0;

        //валидация стрингов
        //валидация цифр
        //количество попыток

        String s = br.readLine();
        String[] array = s.split(" ");

        for (int i = 0; i < 2 ; i++) {
            if (array.length !=10 || !isDigit(array)){
                System.out.println("Wrong");
                s = br.readLine();
                array = s.split(" ");
            }
            if (i == 1){
                System.out.println("Your numbers are wrong");
                break;
            }
            else {
                System.out.println(sumOfDigits(stringToDigits(array)));

            }
            
        }


    }

    static boolean isDigit(String[] array) {


        for (int i = 0; i < array.length; i++) {
            char[] syms = array[i].toCharArray();
            for (char sym : syms) {
                if (!Character.isDigit(sym))return false;
            }
        }

        return true;
    }
    
    static int[] stringToDigits(String[] array){
        int[] digits = new int[array.length];
        
        for (int i = 0; i <array.length ; i++) {
            digits[i] = Integer.parseInt(array[i]);            
        }   
        return digits;
    }

    static int sumOfDigits(int[] digits) {
        int sum = 0;

        for (int i = 0; i <digits.length; i++) {
            sum += digits[i];
        }

        return sum;
    }


}
