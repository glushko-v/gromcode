package gromcode.main.lesson11.interfaceexample;

public class MySQLProvider implements DbProvider {

    @Override
    public void encryptData() {

    }

    @Override
    public void connectToDb(){
        //logic for MySQL
    }

    @Override
    public void disconnectFromDb() {

    }
}
