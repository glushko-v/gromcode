package lesson8.phones;

public class Android extends Phone {


    String androidVersion;
    int screenSize;

    String SecretDeviseCode;

    public Android(int price, double weight, String coutryProduced, String androidVersion, int screenSize, String secretDeviseCode) {

        super(price, weight, coutryProduced);
        this.androidVersion = androidVersion;
        this.screenSize = screenSize;
        SecretDeviseCode = secretDeviseCode;
    }



    void installNewAndroidVersion() {
        System.out.println("installNewAndroidVersion invoked...");

    }
}
