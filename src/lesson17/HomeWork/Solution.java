package lesson17.HomeWork;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        String test = "aaa 123 qwwa 134 452 888";
        System.out.println(Arrays.toString(findNumbers(test)));

    }


    static int[] findNumbers(String text) {
        String[] words = text.split(" ");
        int count = 0;
        for (String word : words) {
            if (isDigit(word)) count++;
        }


        int[] numbers = new int[count];
        int index = 0;

        for (String word : words) {

            if (isDigit(word)) {
                numbers[index] = Integer.parseInt(word);
                index++;


            }


        }
        return numbers;
    }


//    static int[] findNumbers(String text) {
//
//
//
//
//        String[] words = text.split(" ");
//        int count = 0;
//
//        for (String word: words) {
//            if(isDigit(word)) count++;
//        }
//
//        int[] numbers = new int[count];
//
//
//        try {
//            for (int i = 0; i < words.length; i++) {
//
//                if (isDigit(words[i])) numbers[i] = Integer.parseInt(words[i]);
//
//            }
//        }catch (Exception e){
//            System.out.println("Err");
//        }
//        return numbers;
//    }

    static boolean isDigit(String input) {

        char[] syms = input.toCharArray();

        for (char sym : syms) {
            if (!Character.isDigit(sym)) return false;
        }

        return true;
    }
}

