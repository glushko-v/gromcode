package gromcode.main.lesson5;

public class ArraysPractice {
    public static int maxElement(int[] array) {
        int max = array[0];
        for (int element: array) {
            if (element > max) max = element;
        }
        return max;
    }

    public static int nCount(int[] array, int n) {
        int count = 0;
        for (int el: array) {
            if (el==n) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] array = {-10, 2, 0, 25, 13, -4, 48, 60,-100};
        System.out.println(maxElement(array));
        System.out.println(nCount(array, 2));
    }
}
