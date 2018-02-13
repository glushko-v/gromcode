package lesson7;

import lesson6.Order;
import java.util.Date;

public class DemoHomeWork {


     static Order createOrder(){
         Date current = new Date();
        Order order1 = new Order(100, current, false, null, "Dnepr", "Ukraine", "Buy");
        return order1;

    }

    static Order createOrderAndCallMethods(){
        Date current = new Date();
        Order order2 = new Order(100, current, true, current, "Kiev", "Ukraine", "SomeValue");
        order2.checkPrice();
        order2.confirmOrder();
        order2.isValidType();
        return order2;


    }

    public static void main(String[] args) {
        createOrderAndCallMethods();


    }


}
