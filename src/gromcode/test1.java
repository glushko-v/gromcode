package gromcode;

public class test1 {
    public static long sum (int from, int to) {
        long sum = 0;
        for (long i = from; i <=to ; i++) {
              sum +=i;
        }
        return sum;
    }

    public static boolean compareSums (int a, int b, int c, int d) {
        if (sum(a,b)>sum(c,d)) return true;
        else return false;
    }

    public static void main(String[] args) {
        System.out.println(compareSums(1,6, 2, 7));
    }
}
