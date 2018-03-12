package lesson11.interfaceexample;

public class PostgreSQLDbProvider implements DbProvider {

    private String dbHost;

    @Override
    public void encryptData() {

    }

    @Override
    public void connectToDb() {
        //logic for postgres
    }

    @Override
    public void disconnectFromDb(){
        //logic for postgress
    }

    void printDbHost(){
        System.out.println("DB host is" + dbHost);
    }
}
