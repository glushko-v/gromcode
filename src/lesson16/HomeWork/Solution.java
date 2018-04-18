package lesson16.HomeWork;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        String test = "bla bla bla !@# d@ bla bl12";
        String[] results = test.split(" ");
        int count = 0;


        for (int i = 0; i < results.length; i++) {
            byte[] res = results[i].getBytes();


            for (int j = 0; j < res.length; j++) {
                if (res[j] <= 65 && res[j] >= 90) break;
                else if (res[j] <= 97 && res[j] >= 122) break;
                else if ((res[j] >= 65 && res[j]<= 90) || (res[j] >= 97 && res[j] <= 122))
                System.out.print(res[j] + " ");

            }


//            for (int j = 0; j <res.length; j++) {
//                if (res[j] == 98) break;
//                else System.out.print(res[j] + " ");
//            }

        }



//        for (String result: results) {
//            System.out.print(Arrays.toString(result.getBytes()));
//        }


//        byte[] numbers = new byte[results.length];
//
//        for (int i = 0; i <results.length; i++) {
//            numbers[i] =
//        }


    }

    static int countWords(String input) {

        String[] results = input.split(" ");

//        for (String result: results) {
//            byte[] numbers = result.getBytes();
//        }


        int count = 0;

        for (String result : results) {
            if (result != null && !result.equals("")) count++;
        }

        return count;

    }

//    static int validateWords()
    //1. Пробежаться по всем элемента массива
    //2. Если элемент содержит символ, то его не учитывать
    // Каждый элемент массива преобразовываем в символьный массив?
    // Каждый элемент массива преобразовываем в массив байтов, потом определяем находятся ли числа в нужном диапазоне
    // если элемент массива попадает в диапазон - continue, если нет - return


}
