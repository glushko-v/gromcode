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

//        String[] cities = {"Kiev", "Odessa", "Dnepr", "Kharkov"};
//
//
//        for (String city : cities) {
//            if (city == getShipFromCity()) setDateConfirmed(new Date());
//            if (city == getShipToCity()) setDateConfirmed(new Date());
//
//        }
//        if (getBasePrice() >= 100) setDateConfirmed(new Date());
//        if (getCustomerOwned().getGender() == "Female") setDateConfirmed(new Date());
        if (getShipFromCity() == "Kiev" || getShipFromCity() == "Odessa" || getShipFromCity() == "Dnepr" || getShipFromCity() == "Kharkov")
            setDateConfirmed(new Date());
        if (getShipToCity() == "Kiev" || getShipToCity() == "Odessa" || getShipToCity() == "Dnepr" || getShipToCity() == "Kharkov")
            setDateConfirmed(new Date());
        if (getBasePrice() >= 100) setDateConfirmed(new Date());
        getCustomerOwned().getName();
        if (getCustomerOwned().getGender() == "Female") setDateConfirmed(new Date());

    }

    @Override
    void calculatePrice() {

        if (getShipToCity() != "Kiev" || getShipToCity() != "Odessa") setTotalPrice(getTotalPrice()*0.15);
        else setTotalPrice(getBasePrice() * 0.1);
    }
}
