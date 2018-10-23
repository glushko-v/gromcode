package gromcode.main.lesson11.interfaceexample;

public class OracleDbProvider implements DbProvider {

    @Override
    public void encryptData() {

    }

    @Override
    public void connectToDb() {
        //logic for Oracle
    }

    @Override
    public void disconnectFromDb(){
        //logic for Oracle
    }
}
