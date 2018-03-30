package lesson11.HomeWork;


public class Controller {
    private API[] apis;


    public Controller(API[] apis) {
        this.apis = apis;
    }


    Room[] requestRooms(int price, int persons, String city, String hotel) {


        int index = 0;

        for (API api : apis) {
            for (Room room : api.getAll()) {
                if (room.getPrice() == price && room.getPersons() == persons &&
                        room.getCityName() == city && room.getHotelName() == hotel) index++;
            }
        }


        Room[] roomsFound = new Room[index];


        for (API api : apis) {
            for (Room room : api.getAll()) {
                roomsFound = api.findRooms(price, persons, city, hotel);

            }
        }
        return roomsFound;

    }

    Room[] check(API api1, API api2) {


        Room[] api1Rooms = api1.getAll();
        Room[] api2Rooms = api2.getAll();
        int index = 0;


        for (Room room : api1Rooms) {
            for (Room room1 : api2Rooms) {
                if (room.getPersons() == room1.getPersons()) {
                    if (room.getPrice() == room1.getPrice()) {
                        if (room.getCityName() == room1.getCityName()) {
                            if (room.getHotelName() == room1.getHotelName()) index++;
                        }
                    }
                }
            }
        }
        Room[] roomsFound = new Room[index];
        int count = 0;

        for (Room room : api1Rooms) {
            for (Room room1 : api2Rooms) {
                if (room.getPersons() == room1.getPersons()) {
                    if (room.getPrice() == room1.getPrice()) {
                        if (room.getCityName() == room1.getCityName()) {
                            if (room.getHotelName() == room1.getHotelName()){
                                roomsFound[count] = room;
                                count++;
                            }

                        }
                    }
                }

            }
        }


        return roomsFound;
    }


}
