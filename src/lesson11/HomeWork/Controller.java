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

        for (Room room: api1Rooms){
            if (api1.findRooms(room.getPrice(), room.getPersons(), room.getCityName(), room.getHotelName()) ==
                    api2.findRooms(room.getPrice(), room.getPersons(), room.getCityName(), room.getHotelName()))
                roomsFound = api1.findRooms(room.getPrice(), room.getPersons(), room.getCityName(), room.getHotelName());
        }





        return roomsFound;
    }


}
