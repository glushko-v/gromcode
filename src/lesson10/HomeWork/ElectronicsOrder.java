package lesson10.HomeWork;

import java.util.Date;

public class ElectronicsOrder extends Order {

    private int guaranteeMonths;

    public ElectronicsOrder(String itemName, Date dateCreated, String shipFromCity, String shipToCity, int basePrice, Customer customerOwned, int guaranteeMonths) {
        super(itemName, dateCreated, shipFromCity, shipToCity, basePrice, customerOwned);
        this.guaranteeMonths = guaranteeMonths;
    }


    @Override
    public void validateOrder() {


        getCustomerOwned().getName();

        if (getBasePrice() >= 100) {
            if (getCustomerOwned().getGender() == "Женский") {
                switch (getShipFromCity()) {
                    case "Киев":
                        if (getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков")
                            setDateConfirmed(new Date());
                    case "Одесса":
                        if (getShipToCity() == "Киев" || getShipToCity() == "Днепр" || getShipToCity() == "Харьков")
                            setDateConfirmed(new Date());
                    case "Харьков":
                        if (getShipToCity() == "Одесса" || getShipToCity() == "Днепр" || getShipToCity() == "Киев")
                            setDateConfirmed(new Date());
                    case "Днепр":
                        if (getShipToCity() == "Одесса" || getShipToCity() == "Киев" || getShipToCity() == "Харьков")
                            setDateConfirmed(new Date());
                    default:
                        break;
                }
            }
        }
    }

    @Override
    public void calculatePrice() {
        String city = getShipToCity();
        if (city == null) return;
        int basePrice = getBasePrice();
        double commission;
        double bonus = 0D;

        if (city.equalsIgnoreCase("Киев") || city.equalsIgnoreCase("Одесса"))
            commission = (basePrice * 0.01 * 10);
        else commission = (basePrice * 0.01 * 15);

        if (basePrice > 1000)
            bonus = (basePrice + commission)*0.01*5;
        setTotalPrice(basePrice + commission - bonus);


//        double shippingPrice;
//        if (getShipToCity() != "Киев" || getShipToCity() != "Одесса") shippingPrice = getBasePrice() * 0.15;
//        else shippingPrice = getBasePrice() * 0.1;
//
//        if (getBasePrice() > 1000) setTotalPrice((getBasePrice() + shippingPrice) * 0.95);
//        else setTotalPrice(getBasePrice() + shippingPrice);


    }
}
