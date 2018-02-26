package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
    }

    private int guaranteeMonths;

    @Override
    void calculatePrice() {
        int price = getBasePrice();
    }

    @Override
    void validateOrder() {
        //проверить равен ли getShipFromCity одному из четырех городов
        //проверить равен ли getShipToCity одному из четырех городов
        //проверить минимальную цену заказа
        //проверить пол

        String[] cities = {"Kiev", "Odessa", "Dnepr", "Kharkov"};

        for (String city: cities) {
            if (city != getShipFromCity()) break;
            if (city != getShipToCity()) break;

        }
    }
}
