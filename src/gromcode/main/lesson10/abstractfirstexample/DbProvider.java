package gromcode.main.lesson10.abstractfirstexample;

public abstract class DbProvider {

    private String dbHost;

    abstract void connectToDb();

    abstract void disconnectFromDb();

    void printDbHost(){
        System.out.println("Db host is" + dbHost);
    }

}
