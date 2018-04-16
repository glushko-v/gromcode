package lesson15.HomeWork1;


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
                        room.getCityName().equals(city) && room.getHotelName().equals(hotel)) index++;
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
                if (room != null && room1 != null) {
                    if (room.getPersons() == room1.getPersons()) {
                        if (room.getPrice() == room1.getPrice()) {
                            if (room.getCityName().equals(room1.getCityName())) {
                                if (room.getHotelName().equals(room1.getHotelName())) index++;
                            }
                        }
                    }
                }
            }
        }
        Room[] roomsFound = new Room[index];
        int count = 0;

        for (Room room : api1Rooms) {
            for (Room room1 : api2Rooms) {
                if (room != null && room1 != null) {
                    if (room.getPersons() == room1.getPersons()) {
                        if (room.getPrice() == room1.getPrice()) {
                            if (room.getCityName().equals(room1.getCityName())) {
                                if (room.getHotelName().equals(room1.getHotelName())) {
                                    roomsFound[count] = room;
                                    count++;
                                }

                            }
                        }
                    }

                }
            }
        }


        return roomsFound;
    }


}
