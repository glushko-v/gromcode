package lesson16.HomeWork;

public class Solution {
    public static void main(String[] args) {

        String test = "boom crash a blaaaaaaa bla d@ bla @#jjjj 124count111 count555 laa bl12 aa sd lala вk";

//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
//        System.out.println(countWords(test));
//        System.out.println(minWord(test));
        System.out.println(maxWord(test));
        System.out.println(minWord(test));



//        System.out.println(mostCountedWords(test));


        //


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
        String maxWord = results[0];

//        for (int i = 0; i < results.length - 1; i++) {
//            if (maxWord.length() < results[i + 1].length()) {
//                maxWord = results[i + 1];
//            }
//        }

        for (String result: results) {
            if (maxWord.length() < result.length() && isWord(result) && isWord(maxWord)) maxWord = result;
        }


        return maxWord;

    }

    static String minWord(String input) {
        String[] results = input.split(" ");
        String minWord = results[0];

//        for (int i = 0; i < results.length - 1; i++) {
//            if (minWord.length() > results[i + 1].length()) {
//                minWord = results[i + 1];
//            }
//        }

        for (String result: results) {
            if (minWord.length() > result.length() && isWord(result) && isWord(minWord)) minWord = result;
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

    static String mostCountedWords(String input) {
        String[] res = input.split(" ");
//        String word = res[0];









        return null;
    }


}
