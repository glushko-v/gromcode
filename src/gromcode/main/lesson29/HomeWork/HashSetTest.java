package gromcode.main.lesson29.HomeWork;

import java.util.Arrays;
import java.util.HashSet;

public class HashSetTest {

    void useHashSet(){

        Order order1 = new Order(111, 100, "UAH", "Cup", "123asd");
        Order order2 = new Order(222, 150, "UAH", "Glass", "65as4df");
        Order order3 = new Order(333, 25, "UAH", "Paper", "12k3j");
        Order order4 = new Order(444, 1500, "USD", "PC", "asd123");
        Order order5 = new Order(555, 300, "USD", "Phone", "asqf56");


        HashSet<Order> orders = new HashSet<>();

        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);

//        System.out.println(orders);

//        orders.remove(order3);

        HashSet<Order> orders1 = new HashSet<>();

        orders1.add(order1);
        orders1.add(order2);
//        orders1.add(order3);
//        orders1.add(order4);
//        orders1.add(order5);

        System.out.println("First orders " + orders);
        System.out.println("Second orders " + orders1);

        orders.retainAll(orders1);

        System.out.println("First orders " + orders);

        System.out.println(Arrays.toString(orders.toArray()));
        System.out.println(orders1.size());









    }

}
