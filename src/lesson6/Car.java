package lesson6;

public class Car {
    //ПОЛЯ
    int price;
    int yearOfManufacturing;
    String color;
    String ownerName;
    double weight;
    int horsePower;

    public Car(int price, int yearOfManufacting, String ownerName) {
        this.price = price;
        this.yearOfManufacturing = yearOfManufacturing;
        this.ownerName = ownerName;
    }

    //МЕТОДЫ
    void startRun(){
        System.out.println("I am running....");
    }

    void stopRun(){
        System.out.println("I am stopping...");
    }

    void changeOwner (String newOwnerName){
        ownerName = newOwnerName;
    }

    private class Test{

    }

}
