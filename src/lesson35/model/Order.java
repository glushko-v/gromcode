package lesson35.model;

import java.util.Date;

import static lesson35.model.Room.date1;
import static lesson35.model.Room.date2;
import static lesson35.model.Room.date4;

public class Order {
    private long id;
    private User user;
    private Room room;
    private Date dateFrom;
    private Date dateTo;
    private double moneyPaid;

    public Order(long id, User user, Room room, Date dateFrom, Date dateTo, double moneyPaid) {
        this.id = id;
        this.user = user;
        this.room = room;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.moneyPaid = moneyPaid;
    }

    public long getId() {
        return id;
    }


    public User getUser() {
        return user;
    }


    public Room getRoom() {
        return room;
    }


    public Date getDateFrom() {
        return dateFrom;
    }


    public Date getDateTo() {
        return dateTo;
    }


    public double getMoneyPaid() {
        return moneyPaid;
    }

    public static Order order1 = new Order(111, User.user1, Room.room1, date1, new Date(), 100);
    public static Order order2 = new Order(222, User.user2, Room.room2, date2, new Date(), 100);
    public static Order order3 = new Order(333, User.user3, Room.room3, date4, new Date(), 100);


}
