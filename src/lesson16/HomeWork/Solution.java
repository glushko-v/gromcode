package lesson16.HomeWork;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "https://government.org";

//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
//        System.out.println(countWords(test));
//        System.out.println(minWord(test));
//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
        System.out.println(validate(test));


    }


    static int countWords(String input) {

        String[] results = input.split(" ");


        int count = 0;

        for (String result : results) {

            if (result != null && !result.equals("") && isWord(result)) {

                count++;
            }
        }

        return count;

    }

    static String maxWord(String input) {
        String[] results = input.split(" ");
        String maxWord = null;
        if (results.length == 0) return null;

        for (String result : results) {
            if (result.length() > 0 && isWord(result)) {
                maxWord = result;
                break;
            }
        }

        if (maxWord == null) return null;

        for (String result : results) {
            if (result.length() > maxWord.length() && isWord(result)) maxWord = result;
        }
        return maxWord;

    }

    static String minWord(String input) {
        String[] results = input.split(" ");
        String minWord = null;
        if (results.length == 0) return null;

        for (String result : results) {
            if (result.length() > 0 && isWord(result)) {
                minWord = result;
                break;
            }
        }

        if (minWord == null) return null;

        for (String result : results) {
            if (result.length() < minWord.length() && isWord(result) && result.length() > 0) minWord = result;
        }


        return minWord;

    }

    static boolean isWord(String input) {
        char[] letters = input.toCharArray();
        for (char letter : letters) {
            if (!Character.isLetter(letter)) return false;
        }

        return true;

    }

    static String mostCountedWord(String input) {
        if (input.isEmpty()) return null;

        String[] words = input.split(" ");
        int maxCount = 0;
        String mostFrequent = null;

        for (String word : words) {
            int count = 0;
            for (String item : words) {
                if (word.equals(item) && word.length() > 0 && isWord(item)) count++;
            }
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = word;
            }


        }


        return mostFrequent;
    }

    static boolean validate(String address) {

        if (address.isEmpty()) return false;
//        if (address == null) return false;
        if (address.startsWith("http://") || address.startsWith("https://")) {
            if (address.endsWith(".com") || (address.endsWith(".net")) || address.endsWith(".org")) {
                String[] words = address.split("://");
                if (words.length == 0) return false;

                String temp = null;

                for (String word : words) {
                    if (word.contains(".com")) temp = word.replace(".com", "");
                    if (word.contains(".net")) temp = word.replace(".net", "");
                    if (word.contains(".org")) temp = word.replace(".org", "");

                }

                if (temp == null) return false;


                char[] syms = temp.toCharArray();

                for (char sym : syms) {
                    if (!Character.isLetter(sym) && !Character.isDigit(sym) ) return false;


                }


                for (String word : words) {
                    if (word == null) return false;
                }


                return (!words[1].startsWith("."));


            } else return false;
        } else return false;


    }


}
