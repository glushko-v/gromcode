package lesson16.HomeWork;

import java.sql.SQLOutput;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "";
        System.out.println(countWords(test));

    }

    public static int countWords(String input){

        String[] results = input.split(" ");
        int count = 0;

        for (String result: results) {
            if (!result.equals(null) && !result.equals("")) count++;
        }

        return count;

    }
}
