package lesson35.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Room {
    private long id;
    private int numberOfGuests;
    private double price;
    private boolean breakfastIncluded;
    private boolean petsAllowed;
    private Date dateAvailableFrom;
    private Hotel hotel;

    public Room(long id, int numberOfGuests, double price, boolean breakfastIncluded, boolean petsAllowed, Date dateAvailableFrom, Hotel hotel) {
        this.id = id;
        this.numberOfGuests = numberOfGuests;
        this.price = price;
        this.breakfastIncluded = breakfastIncluded;
        this.petsAllowed = petsAllowed;
        this.dateAvailableFrom = dateAvailableFrom;
        this.hotel = hotel;
    }

    public long getId() {
        return id;
    }

    public int getNumberOfGuests() {
        return numberOfGuests;
    }

    public double getPrice() {
        return price;
    }

    public boolean isBreakfastIncluded() {
        return breakfastIncluded;
    }

    public boolean isPetsAllowed() {
        return petsAllowed;
    }

    public Date getDateAvailableFrom() {
        return dateAvailableFrom;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
    public static Date date1;


    static {
        try {

            date1 = sdf.parse("20-12-2018");

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static Room room1 = new Room(111, 2, 100, false, false, date1, Hotel.hotel45);
    public static Room room2 = new Room(222, 1, 50, true, false, new Date(22-12-2018), Hotel.hotel);
    public static Room room3 = new Room(333, 2, 150, true, false, new Date(22-12-2018), Hotel.hotel2);
    public static Room room4 = new Room(444, 3, 200, false, false, new Date(22-12-2018), Hotel.hotel1);
}
