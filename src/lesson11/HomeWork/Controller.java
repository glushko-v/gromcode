package lesson11.HomeWork;


public class Controller {
    private API[] apis;


    public Controller(API[] apis) {
        this.apis = apis;
    }


    Room[] requestRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] roomsFound = new Room[index];


        for (API api : apis) {
            roomsFound = api.findRooms(price, persons, city, hotel);

        }
        return roomsFound;

    }

    Room[] check(API api1, API api2) {
        int index = 0;
        Room[] roomsFound = new Room[index];

        


        return roomsFound;
    }


}
