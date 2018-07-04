package lesson26;

import java.util.ArrayList;
import java.util.List;

public class ArrayListTest {

    List useList(Order order, int index, Order order1, int index1, Order order2){

        ArrayList<Order> list = new ArrayList<>();
        ArrayList<Order> list1 = new ArrayList<>();

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
