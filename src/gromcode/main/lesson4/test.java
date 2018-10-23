package gromcode.main.lesson4;

public class test {
    public static int findDivCount (short a, short b, int n) {

        int count = 0;
        for (int i = a; i <=b; i++) {
            if (i%n ==0) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(findDivCount((short) 3, (short)5, 3));
    }
}
