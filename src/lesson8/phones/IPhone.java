package lesson8.phones;

public class IPhone extends Phone{


    boolean fingerPrint;

    public IPhone(int price, double weight, String coutryProduced, boolean fingerPrint) {

        super(price, weight, coutryProduced);
        System.out.println("IPhone constructor was invoked...");
        this.fingerPrint = fingerPrint;

    }


    void deleteIPhoneFromDb(){
        System.out.println("deleteIPhoneFromDb invoked...");

    }
}
