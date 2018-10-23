package gromcode.main.lesson8.HomeWork1;

public class Arithmetic {




    boolean check(int[]array){
        int Max = array[0];
        int Min = array[0];

        for (int i = 0; i <array.length-1; i++) {
            if (Max > array[i+1]) Max = array[i+1];
            if (Min < array[i+1]) Min = array[i+1];

        }
        System.out.println("Max is " + Max);
        System.out.println("Min is " + Min);
        long sum = Max + Min;
        System.out.println("Sum is " + sum);
        if (sum > 100) return true;
        else return false;


    }
}
