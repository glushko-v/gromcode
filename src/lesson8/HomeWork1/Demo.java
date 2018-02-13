package lesson8.HomeWork1;

public class Demo {
    public static void main(String[] args) {
        int [] array = {1, 5, 9, 7, 7,10, -5, 112};

        Adder unit2 = new Adder();
        System.out.println(unit2.add(2,3));
        System.out.println(unit2.check(array));

    }
}
