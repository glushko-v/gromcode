package lesson11.HomeWork;


public class Controller {
    private API[] apis;


    public Controller(API[] apis) {
        this.apis = apis;
    }


    Room[] requestRooms(int price, int persons, String city, String hotel) {
        
        Room[] roomsFound = new Room[apis.length];


        for (API api : apis) {
            roomsFound = api.findRooms(price, persons, city, hotel);

        }
        return roomsFound;

    }

    Room[] check(API api1, API api2) {

        Room[] roomsFound = new Room[apis.length];
        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();



        if (api1Rooms == null || api2Rooms == null) return null;

        if (api1Rooms == api2Rooms) roomsFound = api1Rooms;
        return roomsFound;
    }


}
