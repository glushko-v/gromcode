package gromcode.main.lesson15.HomeWork1;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (persons == room.getPersons()) {
                    if (city.equals(room.getCityName())) {
                        if (hotel.equals(room.getHotelName())) {
                            if (price <= (room.getPrice() + 100) || price >= (room.getPrice() - 100)) {
                                index++;
                            }
                        }
                    }
                }
            }
        }
        Room[] roomsFound = new Room[index];
        int count = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (persons == room.getPersons()) {
                    if (city.equals(room.getCityName())) {
                        if (hotel.equals(room.getHotelName())) {
                            if (price <= (room.getPrice() + 100) || price >= (room.getPrice() - 100)) {
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

    @Override
    public Room[] getAll() {
        return rooms;
    }
}
