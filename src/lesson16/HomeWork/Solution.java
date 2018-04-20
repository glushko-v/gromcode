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

        /*Цель: не считать слова, где содержатся символы

        1. Разбиваем стринг на массив знаков
        2. Создаем результирующий массив длиной массива знаков
        3. Пробегаем по массиву знаков. Если среди них есть символ, записываем его в результирующий массив
        4. Разбиваем строку по пробелам. Создаем массив слов
        5. Создаем результирующий массив слов длиной в начальный массив слов
        5. Пробегаем по массиву слов и одновременно по результирующему массиву знаков
        5.1. Если слово из массива содержит символ из массива знаков приравниваем его к ""
        5.2. Если слово не содержит символ - записываем его в результирующий массив слов*/




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
