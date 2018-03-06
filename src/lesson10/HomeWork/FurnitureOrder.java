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

        if ((getShipFromCity() == "Киев" || getShipFromCity() == "Львов")) {
            if (getBasePrice() >= 500) {
                if (getCustomerOwned().getName() != "Test") setDateConfirmed(new Date());
            }
        }


    }

    @Override
    void calculatePrice() {
        if (getBasePrice() < 5000) setTotalPrice((getBasePrice() * 0.05) + getBasePrice());
        else setTotalPrice((getBasePrice() * 0.02) + getBasePrice());
    }
}
