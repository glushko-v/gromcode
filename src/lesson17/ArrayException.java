package lesson17;

public class ArrayException {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};

        try {
            System.out.println(array[3]);
        } catch (Exception e) {
            System.err.println("Element was not found");
        }
        finally {

        }



        System.out.println("Cool...");
        System.out.println("Cool2...");
    }
}
