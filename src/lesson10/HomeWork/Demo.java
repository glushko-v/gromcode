package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Calculator", new Date(), "Kiev", "Odessa",
                100, new Customer("Julia", "Odessa", "Female"), 12);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Table", new Date(), "Lvov", "Nikolaev",
                1500, new Customer("Ivan", "Nikolaev", "Male"), "441");

        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();

        furnitureOrder.validateOrder();
        furnitureOrder.calculatePrice();

    }
}
