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

//        if (getBasePrice() < 1000) {
//            if (getShipToCity() == "Киев" || getShipToCity() == "Одесса")
//                setTotalPrice(getBasePrice()*1.1);
//            else setTotalPrice(getBasePrice()*1.15);
//        }
//        else setTotalPrice(getTotalPrice()*0.95);

        if (getShipToCity() == "Киев" || getShipToCity() == "Одесса") setTotalPrice(getBasePrice() * 1.1);
        else setTotalPrice(getBasePrice()*1.15);
        if (getBasePrice() > 1000) setTotalPrice(getTotalPrice()*0.95);


    }
}
