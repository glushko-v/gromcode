package gromcode.main.lesson11.HomeWork;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }


    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        for (Room room : rooms) {
            if (room != null) {
                if (price == room.getPrice()) {
                    if (city == room.getCityName()) {
                        if (hotel == room.getHotelName()) {
                            if (persons <= (room.getPersons() + 1) || persons >= (room.getPersons() - 1)) {
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
                    if (city == room.getCityName()) {
                        if (hotel == room.getHotelName()) {
                            if (persons <= (room.getPersons() + 1) || persons >= (room.getPersons() - 1)) {
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
