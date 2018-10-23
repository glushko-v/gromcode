package gromcode.main.lesson10.abstractfirstexample;

public class PostgreSQLDbProvider extends DbProvider {

    private String dbHost;

    @Override
    void connectToDb() {
        //logic for postgres
    }

    @Override
    void disconnectFromDb(){
        //logic for postgress
    }

    void printDbHost(){
        System.out.println("DB host is" + dbHost);
    }
}
