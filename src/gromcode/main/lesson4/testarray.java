package gromcode.main.lesson4;
import java.util.Arrays;
import java.util.Scanner;

public class testarray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите размер массива ");
        int size = input.nextInt();
        int[] array = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.println("Введите " + (i+1)+ "-й элемент массива");
            array[i] = input.nextInt();
        }

        System.out.println("Ваш массив: " + Arrays.toString(array));
    }



}
