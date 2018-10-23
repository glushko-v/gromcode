package gromcode.main.lesson31.HomeWork;

import java.util.HashMap;

import java.util.Map;

public class Solution {


     static Map countSymbols(String text) {
        Map<Character, Integer> countSymbols = new HashMap<>();


        char[] syms = text.toCharArray();


        for (int i = 0; i < syms.length; i++) {

            if (Character.isLetter(syms[i]))
            countSymbols.put(syms[i], countSyms(text, syms[i]));


        }


        return countSymbols;
    }

    static int countSyms(String text, char sym) {
        int count = 0;
        char[] syms = text.toCharArray();

        for (int i = 0; i < syms.length; i++) {
            if (syms[i] == sym) count++;
        }


        return count;
    }

    static int countWords (String text, String word){
         int count = 0;
         String[] words = text.split(" ");

        for (String wrd: words) {
            if (isWord(wrd) && wrd.equals(word))count++;
        }

         return count;
    }

    static boolean isWord(String text) {

        char[] syms = text.toCharArray();

        if (syms.length <= 2) return false;



        for (int i = 0; i <syms.length ; i++) {


            if (!Character.isLetter(syms[i])) return false;/*
*/        }



        return true;

    }

    static Map words (String text){
         Map<String, Integer> numWords = new HashMap<>();


         String[] words = text.split(" ");


        for (int i = 0; i <words.length; i++) {
            if (isWord(words[i]))
                numWords.put(words[i], countWords(text, words[i]));
        }


         return numWords;
    }


}
