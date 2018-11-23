package lesson35.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;



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

    public void setId(long id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setDateFrom(Date dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(Date dateTo) {
        this.dateTo = dateTo;
    }

    public void setMoneyPaid(double moneyPaid) {
        this.moneyPaid = moneyPaid;
    }

    public static Order findById(long userId, long roomId, long hotelId) throws Exception {
        StringBuffer orderInfo = new StringBuffer();
        Order order = new Order(0, null, null, null, null, 0);
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\Order.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {

                    if (userId == Long.parseLong(lines[1]) && roomId == Long.parseLong(lines[2])) {
                        orderInfo.append(lines[0] + ", ");
                        orderInfo.append(lines[1] + ", ");
                        orderInfo.append(lines[2] + ", ");
                        orderInfo.append(lines[3] + ", ");
                        orderInfo.append(lines[4] + ", ");
                        orderInfo.append(lines[5]);
                    }

                    break;


                }

            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }

        String orderString = orderInfo.toString();

        String[] orderData = orderString.split(",");

        for (int i = 0; i < orderData.length; i++) {

            order.setId(Long.parseLong(orderData[0]));
            order.setUser(User.findById(userId));
            order.setRoom(Room.findById(roomId, hotelId));
            order.setDateFrom(sdf.parse(orderData[3]));
            order.setDateTo(sdf.parse(orderData[4]));
            order.setMoneyPaid(Double.parseDouble(orderData[5]));


        }


        return order;
    }


}
