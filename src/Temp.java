public class Temp {
    public static void main(String[] args) {
        int sum = 0;
        for (int i = 0; i <= 10000; i++) {
            sum = sum + i;

        }
        System.out.println("Sum is "+sum);
        int div = sum/1234;
        System.out.println("Div is " + div);
        int bal = sum%1234;
        System.out.println("Bal is " + bal);
        boolean out = bal > 1234;
        System.out.println(out);


    }
}
