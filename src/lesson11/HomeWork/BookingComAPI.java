package lesson11.HomeWork;

import java.util.Date;

public class BookingComAPI implements API {
    private Room[] rooms;

    public BookingComAPI(Room[] rooms) {
        this.rooms = rooms;
    }



    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {

        int index = 0;
        Room[] roomsFound = new Room[index];

        if (rooms == null) return null;
        for (Room room : rooms) {
            if (room == null) return null;
            if (persons == room.getPersons()) {
                if (city == room.getCityName()) {
                    if (hotel == room.getHotelName()) {
                        if (price == room.getPrice()) {
                            roomsFound[index] = room;
                            index++;
                        } else if (price <= (room.getPrice() + 100) || price >= (room.getPrice() - 100)){
                            roomsFound[index] = room;
                            index++;
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
