package lesson10.HomeWork;

import java.util.Date;

public class FurnitureOrder extends Order {
    private String furnitureCode;

    public FurnitureOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, String furnitureCode) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.furnitureCode = furnitureCode;
    }

    @Override
    void validateOrder() {

        if (getShipFromCity() == "Kiev" || getShipFromCity() == "Lvov") setDateConfirmed(new Date());
        if (getBasePrice() >= 500) setDateConfirmed(new Date());
        if (getCustomerOwned().getName() != "Test") setDateConfirmed(new Date());


    }

    @Override
    void calculatePrice() {
        double commission;
        double priceWithComm;
        if (getTotalPrice() < 5000) commission = 0.05;
        else commission = 0.02;

        priceWithComm = getTotalPrice()*commission;
    }
}
