package lesson31.HomeWork;

import java.util.HashMap;

import java.util.Map;

public class Solution {


    public static Map countSymbols(String text) {
        Map<Character, Integer> countSymbols = new HashMap<>();

        //результирующий массив с количеством повторений
        //

        char[] syms = text.toCharArray();
        int index = 1;

        for (int i = 0; i <syms.length; i++) {
            for (int j = i+1; j <syms.length-1; j++) {
                if (syms[i]==syms[j]){
                    index++;
                    countSymbols.put(syms[i], index);

                }
                else {
                    index = 0;
                    index++;
                    countSymbols.put(syms[j], index);
                }
            }
        }



        return countSymbols;
    }
}
