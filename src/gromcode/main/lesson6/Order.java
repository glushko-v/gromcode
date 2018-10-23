package gromcode.main.lesson6;

import java.util.Date;

public class Order {
    long id;
    int price;
    Date dateCreated;
    boolean isConfirmed;
    Date dateConfirmed;
    String city;
    String country;
    String type;

    public Order(int price, Date dateCreated, boolean isConfirmed, Date dateConfirmed, String city, String country, String type) {
        this.price = price;
        this.dateCreated = dateCreated;
        this.isConfirmed = isConfirmed;
        this.dateConfirmed = dateConfirmed;
        this.city = city;
        this.country = country;
        this.type = type;
    }

    public Order() {
    }

    public void confirmOrder(){
        if (isConfirmed == false){
            isConfirmed = true;
            dateConfirmed = new Date();
        }

    }

    public boolean checkPrice (){
        if (price > 1000) return true;
        else return false;
    }

    public boolean isValidType (){
        if (type == "Buy") return true;
        if (type == "Sell") return true;
        else return false;
    }
}
