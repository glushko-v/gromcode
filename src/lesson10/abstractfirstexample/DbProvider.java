package lesson10.abstractfirstexample;

public abstract class DbProvider {
    abstract void connectToDb();

    abstract void disconnectFromDb();
}
