package lesson11;

public class Solution {
    public static void main(String[] args) {
        int[] array = {1, 3, 8, 6, 5, 2};
        int index1 = 0;
        int index2 = 0;
        int target = 2;

        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j < array.length-1; j++) {
                int sum = array[i] + array[j];

                if (sum == target && i != j) {
                    index1 = i;
                    index2 = j;
                }


            }
        }
        if ((array[index1] + array[index2]) != target) System.out.println("Not found");

        else {
            System.out.println(index1);
            System.out.println(index2);
        }

    }
}
