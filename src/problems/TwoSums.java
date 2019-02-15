package problems;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class TwoSums  {
    public static void main(String[] args) throws Exception {

        InputStreamReader isr = new InputStreamReader(System.in);
        System.out.println("Please enter integers");
        BufferedReader br = new BufferedReader(isr);


        String input = br.readLine();
        String[] stringDigits = input.split(" ");
        int[] nums = new int[stringDigits.length];
        for (int i = 0; i <stringDigits.length; i++) {
            nums[i] = Integer.parseInt(stringDigits[i]);
        }


        System.out.println("Please enter target");
        input = br.readLine();
        int target = Integer.parseInt(input);

        int count = 0;



        for (int i = 0; i <nums.length; i++) {
            for (int j = i+1; j <nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    count +=1;
                    System.out.print(i + " " + j);
                    System.out.println();

                }

            }

        }
        if (count == 0) System.out.println("No match");

    }
}
