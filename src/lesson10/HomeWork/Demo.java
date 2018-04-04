package lesson10.HomeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        ElectronicsOrder electronicsOrder = new ElectronicsOrder("Calculator", new Date(), "Киев", "Одесса",
                100, new Customer("Julia", "Одесса", "Женский"), 12);
        ElectronicsOrder electronicsOrder1 = new ElectronicsOrder("Player", new Date(), "Одесса", "Львов",
                350, new Customer("Denis", "Львов", "Мужской"), 24);
        FurnitureOrder furnitureOrder = new FurnitureOrder("Table", new Date(), "Львов", "Николаев",
                1500, new Customer("Ivan", "Николаев", "Мужской"), "441");
        FurnitureOrder furnitureOrder1 = new FurnitureOrder("Chair", new Date(), "Киев", "Одесса",
                1000, new Customer("Evgenia", "Одесса", "Женский"), "387");

        electronicsOrder.validateOrder();
        electronicsOrder.calculatePrice();

        electronicsOrder1.validateOrder();
        electronicsOrder1.calculatePrice();

        furnitureOrder.validateOrder();
        furnitureOrder.calculatePrice();

        furnitureOrder1.validateOrder();
        furnitureOrder1.calculatePrice();

        //calculatePrice, validateOrder - FurnitureOrder
        //1. если цена отрицательная
        //2. null check
        //3. одинаковые города shipTo и shipFrom
        //4. правильный расчет цены +++
        //validateOrder - FurnitureOrder
        //1.правильная валидация (любые города, кроме Киева и Львова, имя - Тест)
        //2. минимальная цена заказа +++
        //validateOrder - ElectronicsOrder
        //1. проверка пола
        //2. null check
        //3. проверка города
        //calculatePrice - ElectronicsOrder
        //1. отрицательная цена
        //2. null check
        //3. отправка не из Киева и Одессы
        //4. Одинаковые города
        //5. Правильный расчет цены +++
        // confirmShipping - null check

        System.out.println(electronicsOrder1.getTotalPrice());
        System.out.println(furnitureOrder1.getTotalPrice());


        ElectronicsOrder electronicsOrder2 = new ElectronicsOrder("Keyboard", new Date(), "Moscow",
                "Одесса", -4000, new Customer(null, null, "Мужской"), 1);
        FurnitureOrder furnitureOrder2 = new FurnitureOrder("Coach", null, "Одесса",
                "Одесса", -2, new Customer ("Тест", null, "Женский"), "222");

        furnitureOrder2.validateOrder();
        System.out.println(furnitureOrder2.getTotalPrice());





    }
}
