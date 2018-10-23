package gromcode.main.lesson19;

public class ThrowExample {
    private static String[] array = {"test", "test1", null, "test2", "test3"};

    public static void main(String[] args) {
        useOfTestMethod();
    }


    private static void test() throws Exception{

        //some code

        for (String element: array){
            if(element == null) throw new Exception ("null is detected");
        }

        System.out.println("done");

    }

    private static void useOfTestMethod() {
        try {
            test();
        }catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}
