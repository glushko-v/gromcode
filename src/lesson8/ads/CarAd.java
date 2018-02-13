package lesson8.ads;

public class CarAd extends Ad {
    public CarAd(long id, int price) {
        super(id, price);
    }
    String model;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    void confirmAd(){
        //some logic
    }
}
