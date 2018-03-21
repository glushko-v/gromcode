package lesson11.HomeWork;


public class Controller {
    private API[] apis;


    public Controller(API[] apis) {
        this.apis = apis;
    }


    Room[] requestRooms(int price, int persons, String city, String hotel) {

        int index = 0;
        for (API api : apis) {
            if (api.findRooms(price, persons, city, hotel) != null) index++;
        }
        Room[] roomsFound = new Room[index];


        for (API api : apis) {
            roomsFound = api.findRooms(price, persons, city, hotel);

        }
        return roomsFound;

    }

    Room[] check(API api1, API api2) {


        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();
        Room[] roomsFound = new Room[api1Rooms.length];



        if (api1Rooms == null || api2Rooms == null) return null;

        for (API api: apis) {
            if (api.getAll() == api1Rooms && api.getAll() == api2Rooms) roomsFound = api1Rooms;
        }



        return roomsFound;
    }


}
