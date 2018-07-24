package lesson31.HomeWork;

import java.util.HashMap;

import java.util.Map;

public class Solution {


    public static Map countSymbols(String text) {
        Map<Character, Integer> countSymbols = new HashMap<>();

        //результирующий массив с количеством повторений
        //

        char[] syms = text.toCharArray();
        int index = 0;

        for (int i = 0; i < syms.length; i++) {

            if (Character.isLetter(syms[i]))
            countSymbols.put(syms[i], count(text, syms[i]));


        }


        return countSymbols;
    }

    static int count(String text, char sym) {
        int count = 0;
        char[] syms = text.toCharArray();

        for (int i = 0; i < syms.length; i++) {
            if (syms[i] == sym) count++;
        }


        return count;
    }
}
