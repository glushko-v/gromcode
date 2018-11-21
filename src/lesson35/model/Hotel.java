package lesson35.model;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Hotel {
    private long id;
    private String name;
    private String country;
    private String city;
    private String street;

    public Hotel(long id, String name, String country, String city, String street) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.city = city;
        this.street = street;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }


    @Override
    public String toString() {
        return name + ", " + city;


    }

    public static Hotel hotel45 = new Hotel(145, "Konrad", "Turkey", "Istanbul", "Some street");
    public static Hotel hotel = new Hotel(111, "Hilton", "Ukraine", "Kiev", "Shevchevnko");
    public static Hotel hotel1 = new Hotel(222, "Ibis", "Belgium", "Brussels", "Unknown");
    public static Hotel hotel2 = new Hotel(333, "4Seasons", "Spain", "Madrid", "test");

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public static Hotel findById(long id) {
        StringBuffer hotelInfo = new StringBuffer();
        Hotel hotel = new Hotel(0, null, null, null, null);


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\HotelDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {

                    if (id == Long.parseLong(lines[0])) {
                        hotelInfo.append(lines[0] + ", ");
                        hotelInfo.append(lines[1] + ", ");
                        hotelInfo.append(lines[2] + ", ");
                        hotelInfo.append(lines[3] + ", ");
                        hotelInfo.append(lines[4]);
                    }

                    break;



                }

            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }

        String hotelString = hotelInfo.toString();

        String[] hotelData = hotelString.split(",");

        for (int i = 0; i <hotelData.length; i++) {

            hotel.setId(Long.parseLong(hotelData[0]));
            hotel.setName(hotelData[1]);
            hotel.setCity(hotelData[2]);
            hotel.setCountry(hotelData[3]);
            hotel.setStreet(hotelData[4]);

        }


        return hotel;
    }


}
