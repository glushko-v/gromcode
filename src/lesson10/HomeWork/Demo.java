package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Calculator", new Date(), "Kiev", "Odessa",
                100, new Customer("Julia", "Odessa", "Female"), 12);
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Player", new Date(), "Odessa", "Lvov",
                350, new Customer("Denis", "Lvov", "Male"), 24);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Table", new Date(), "Lvov", "Nikolaev",
                1500, new Customer("Ivan", "Nikolaev", "Male"), "441");
        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Chair", new Date(), "Kiev", "Odessa",
                1000, new Customer("Evgenia", "Odessa", "Female"), "387");

        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();

        furnitureOrder.validateOrder();
        furnitureOrder.calculatePrice();

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();

    }
}
