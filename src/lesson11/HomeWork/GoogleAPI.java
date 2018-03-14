package lesson11.HomeWork;

public class GoogleAPI implements API {
    private Room[] rooms;

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] roomsFound = new Room[index];


        for (Room room : rooms) {
            if (room == null) return null;
            if (price == room.getPrice()) {
                if (persons == room.getPersons()) {
                    if (city == room.getCityName()) {
                        if (hotel == room.getHotelName()) {
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


