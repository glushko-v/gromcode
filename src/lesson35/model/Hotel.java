package lesson35.model;

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
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", city='" + city + '\'';
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
}
