package lesson11.HomeWork;

import java.util.Arrays;

public class GoogleAPI implements API {
    private Room[] rooms;

    public GoogleAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (price == room.getPrice()) {
                    if (persons == room.getPersons()) {
                        if (city == room.getCityName()) {
                            if (hotel == room.getHotelName()) {
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
                if (price == room.getPrice()) {
                    if (persons == room.getPersons()) {
                        if (city == room.getCityName()) {
                            if (hotel == room.getHotelName()) {
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


