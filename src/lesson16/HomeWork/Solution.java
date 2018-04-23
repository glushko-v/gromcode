package lesson16.HomeWork;

import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {

        String test = "boom crash bla bla d@ bla @#jjjj 124count count555 lalalalalalalala bl12 aa sd lala вл";

//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
//        isWord(test);
        System.out.println(countWords(test));


    }


    static int countWords(String input) {

        String[] results = input.split(" ");


        int count = 0;

        for (String result : results) {

            if (result != null && !result.equals("")) {
//                isWord(result);
                count++;
            }
        }

        return count;

    }

    static String maxWord(String input) {
        String[] results = input.split(" ");
        String maxWord = null;
        int count = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[count].length() < results[i].length()) {
                count = i;
                maxWord = results[count];
            }

        }

        return maxWord;


    }

    static String minWord(String input) {
        String[] results = input.split(" ");
        String minWord = null;
        int count = 0;

        for (int i = 0; i < results.length; i++) {
            if (results[count].length() > results[i].length()) {
                count = i;
                minWord = results[count];
            }

        }

        return minWord;

    }

    static void isWord(String input) {
        String[] results = input.split(" ");
        for (int i = 0; i < results.length; i++) {
            char[] symbols = results[i].toCharArray();
            for (char symbol : symbols) {
                if (!Character.isLetter(symbol)) {
                    results[i] = null;

                }


            }
            System.out.print(results[i] + " ");
        }


    }


}
