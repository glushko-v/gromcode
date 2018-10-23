package gromcode.main.lesson8.phones;

public class Phone {
    int price;
    double weight;
    String coutryProduced;

    public Phone(int price, double weight, String coutryProduced) {
        System.out.println("Phone cosntructor was invoked...");
        this.price = price;
        this.weight = weight;
        this.coutryProduced = coutryProduced;
    }

    void orderPhone(){
        System.out.println("order phone invoked...");
    }
}
