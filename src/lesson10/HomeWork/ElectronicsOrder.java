package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }


    @Override
    void validateOrder() {

        String[] cities = {"Киев", "Одесса", "Днепр", "Харьков"};

        for (int i = 0; i < cities.length; i++) {
            for (int j = 0; j < cities.length; j++) {
                if (getShipToCity() == cities[i]){
                    if (getShipFromCity() == cities[j]) setDateConfirmed(new Date());
                }
            }
        }


//        if (getShipFromCity() == "Киев" || getShipFromCity() == "Одесса" || getShipFromCity() == "Днепр" ||
//                getShipFromCity() == "Харьков")
//            setDateConfirmed(new Date());
//        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса" || getShipToCity() == "Днепр" ||
//                getShipToCity() == "Харьков")
//            setDateConfirmed(new Date());
        if (getBasePrice() >= 100) setDateConfirmed(new Date());
        getCustomerOwned().getName();
        if (getCustomerOwned().getGender() == "Женский") setDateConfirmed(new Date());

    }

    @Override
    void calculatePrice() {

        if (getShipToCity() != "Киев" || getShipToCity() != "Одесса")
            setTotalPrice((getBasePrice() * 0.15) + getBasePrice());
        else setTotalPrice((getBasePrice() * 0.1) + getBasePrice());

        if (getTotalPrice() > 1000) setTotalPrice(getTotalPrice() * 0.95);
    }
}
