package lesson16.HomeWork;

import java.util.Arrays;


public class Solution {
    public static void main(String[] args) {

        String test = "bla bla bla !@# d@ bla bl12";

        String[] words = test.split(" ");
        char[] letters = test.toCharArray();
        int count = 0;

        for (char letter: letters) {
            if (!Character.isWhitespace(letter) && !Character.isLetter(letter))count++;
        }

        char[] symbols = new char[count];

        


    }


    static int countWords(String input) {

        String[] results = input.split(" ");


        int count = 0;

        for (String result : results) {
            if (result != null && !result.equals("")) count++;
        }

        return count;

    }


}
