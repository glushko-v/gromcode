package lesson35.model;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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

    public void setDateAvailableFrom(Date dateAvailableFrom) {
        this.dateAvailableFrom = dateAvailableFrom;
    }


    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    public static Calendar calendar = Calendar.getInstance();

    public static String dateString = "20-12-2018";
    public static String dateString1 = "01-01-2019";
    public static String dateString2 = "23-11-2018";
    public static String dateString3 = "23-11-2018";

    public static Date date1;
    public static Date date2;
    public static Date date3;
    public static Date date4;
    public static Date date;


    static {
        try {

            date1 = sdf.parse(dateString);
            date2 = sdf.parse(dateString1);
            date3 = sdf.parse(dateString2);
            date4 = sdf.parse(dateString3);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static Room room1 = new Room(111, 2, 100, false, false, date1, Hotel.hotel45);
    public static Room room2 = new Room(222, 1, 50, true, false, new Date(22 - 12 - 2018), Hotel.hotel);
    public static Room room3 = new Room(333, 2, 150, true, false, new Date(22 - 12 - 2018), Hotel.hotel2);
    public static Room room4 = new Room(444, 3, 200, false, false, new Date(22 - 12 - 2018), Hotel.hotel1);

    public void setId(long id) {
        this.id = id;
    }

    public void setNumberOfGuests(int numberOfGuests) {
        this.numberOfGuests = numberOfGuests;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setBreakfastIncluded(boolean breakfastIncluded) {
        this.breakfastIncluded = breakfastIncluded;
    }

    public void setPetsAllowed(boolean petsAllowed) {
        this.petsAllowed = petsAllowed;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public static Room findById(long roomId, long hotelId) {
        StringBuffer roomInfo = new StringBuffer();
        Room room = new Room(0, 0, 0, false, false, null, null);


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\RoomDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {

                    if (roomId == Long.parseLong(lines[0])) {
                        roomInfo.append(lines[0] + ", ");
                        roomInfo.append(lines[1] + ", ");
                        roomInfo.append(lines[2] + ", ");
                        roomInfo.append(lines[3] + ", ");
                        roomInfo.append(lines[5] + ", ");
                        roomInfo.append(lines[6]);
                    }

                    break;


                }

            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }

        String roomString = roomInfo.toString();

        String[] roomData = roomString.split(",");

        for (int i = 0; i < roomData.length; i++) {

            room.setId(Long.parseLong(roomData[0]));
            room.setNumberOfGuests(Integer.parseInt(roomData[1]));
            room.setPrice(Integer.parseInt(roomData[2]));
            room.setBreakfastIncluded(Boolean.getBoolean(roomData[3]));
            room.setPetsAllowed(Boolean.getBoolean(roomData[4]));
            room.setDateAvailableFrom(new Date());
            room.setHotel(Hotel.findById(hotelId));

        }


        return room;
    }
}
