package gromcode.main.lesson25;

public class Order extends IdEntity {
    private long id;

    public Order(long id) {
        this.id = id;
    }

    public long getId() {
        return id;
    }
}
