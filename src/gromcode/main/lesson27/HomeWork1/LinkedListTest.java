package gromcode.main.lesson27.HomeWork1;

import gromcode.main.lesson26.Order;


import java.util.LinkedList;
import java.util.List;

public class LinkedListTest {

    List useList(){

        Order order = new Order(11, 250, "UAH", "Kettle", "5465df");
        Order order1 = new Order (12, 100, "UAH", "Pan", "aaa87");
        Order order2 = new Order(13, 150, "UAH", "Fan", "1234ggg");
        int index = 1;
        int index1 = 5;


        LinkedList<Order> list = new LinkedList<>();
        LinkedList<Order> list1 = new LinkedList<>();

        list.add(order);
        list.add(index, order1);
        list.remove(index1);
        list.remove(order);
        list.addAll(list1);
        list.subList(0, index);
        list.set(index1, order2);
        list.contains(order1);
        list.toArray();
        list.clear();





        return list;
    }
}
