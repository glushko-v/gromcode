package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
    }

    private int guaranteeMonths;

    @Override
    void calculatePrice() {
        double shipPrice = getTotalPrice() - getBasePrice();
        if (getShipToCity() != "Kiev" || getShipToCity() != "Odessa") shipPrice = getBasePrice()*0.15;
        else shipPrice = getBasePrice()*0.1;
    }

    @Override
    void validateOrder() {
        //проверить равен ли getShipFromCity одному из четырех городов
        //проверить равен ли getShipToCity одному из четырех городов
        //проверить минимальную цену заказа
        //проверить пол

        String[] cities = {"Kiev", "Odessa", "Dnepr", "Kharkov"};


        for (String city : cities) {
            if (city == getShipFromCity()) setDateConfirmed(new Date());
            if (city == getShipToCity()) setDateConfirmed(new Date());

        }
        if (getBasePrice() >= 100) setDateConfirmed(new Date());
        if (getCustomerOwned().getGender() == "Female") setDateConfirmed(new Date());
        

    }
}
