package lesson11.HomeWork;

public class TripAdvisorAPI implements API {
    private Room[] rooms;

    public TripAdvisorAPI(Room[] rooms) {
        this.rooms = rooms;
    }

    @Override
    public Room[] findRooms(int price, int persons, String city, String hotel) {
        int index = 0;
        Room[] roomsFound = new Room[index];


        for (Room room : rooms) {
            if (room == null) return null;
            if (price == room.getPrice()){
                if (city == room.getCityName()) {
                    if (hotel == room.getHotelName()){
                        if (persons == room.getPersons()) {
                            roomsFound[index] = room;
                            index++;
                        }
                        else if (persons <= (room.getPersons() + 1) || persons >= (room.getPersons()- 1)){
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
