package lesson16.HomeWork;

public class Solution {
    public static void main(String[] args) {

        String test = "asa bla bla bla asa";

//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
//        System.out.println(countWords(test));
//        System.out.println(minWord(test));
//        System.out.println(maxWord(test));
//        System.out.println(minWord(test));
       System.out.println(mostCountedWords(test));


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
        String maxWord = null;
        if (results.length == 0) return null;

        for (String result : results) {
            if (result.length() > 0 && isWord(result)) {
                maxWord = result;
                break;
            }
        }

        if (maxWord == null) return null;

        for (String result: results) {
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

        for (String result: results) {
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

    static int mostCountedWords(String input) {
        String[] res = input.split(" ");
        String word = null;
        if (res.length == 0) return 0;
        int count =0;
        int index =0;



        for (String res1: res) {
            if(res.length>0 && isWord(res1)){
                word = res1;
                break;
            }
        }

        if (word == null) return 0;

        for (int i = 0; i <res.length; i++) {
            word = res[i];
            for (int j = i+1; j <res.length; j++) {
                if (word.equals(res[j])) count++;
            }
        }


        return count;
    }


}
