package lesson10.HomeWork;

import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Calculator", new Date(), "Киев", "Одесса",
                100, new Customer("Julia", "Одесса", "женский"), 12);
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Player", new Date(), "Одесса", "Львов",
                350, new Customer("Denis", "Львов", "мужской"), 24);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Table", new Date(), "Львов", "Николаев",
                1500, new Customer("Ivan", "Николаев", "мужской"), "441");
        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Chair", new Date(), "Киев", "Одесса",
                1000, new Customer("Evgenia", "Одесса", "женский"), "387");

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
