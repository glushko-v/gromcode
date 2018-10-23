package gromcode.main.lesson19;


public class RunTimeExceptionExample {
    public static void main(String[] args) {

        arithmeticException(0);

        try{arithmeticException(0);}
        catch (ArithmeticException e) {
            System.out.println("something wrong");
        }


    }

    private static void arithmeticException (int a){
        System.out.println(10/a);
    }
}
