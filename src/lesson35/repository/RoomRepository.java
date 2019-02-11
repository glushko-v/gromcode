package lesson35.repository;

import lesson35.model.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class RoomRepository extends Repository<Room> {

    @Override
    public long[] readIdFromFile(String path) {
        return super.readIdFromFile(path);
    }

    @Override
    public void delete(long id, String path) {
        super.delete(id, path);
    }

    @Override
    public void writeDataToFile(StringBuffer data, boolean append, String path) {
        super.writeDataToFile(data, append, path);
    }

    @Override
    boolean validateId(long id, String path) {
        return super.validateId(id, path);
    }


    StringBuffer readRoomData(Room room) {
        StringBuffer roomData = new StringBuffer();

        roomData.append(room.getId() + "," + " ");
        roomData.append(room.getNumberOfGuests() + "," + " ");
        roomData.append(room.getPrice() + "," + " ");
        roomData.append(room.isBreakfastIncluded() + "," + " ");
        roomData.append(room.isPetsAllowed() + ", ");
        roomData.append(room.getDateAvailableFrom() + ", ");
        roomData.append(room.getHotel());


        return roomData;
    }




    @Override
    public Room add(Room room, String path) throws Exception {
        if (!validateId(room.getId(), path)) throw new Exception("Room with id " + room.getId() + " already exists");


        writeDataToFile(readRoomData(room), true, path);


        return room;
    }

    public List<Room> returnRooms() {


        ArrayList<Room> objectList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\RoomDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                Room room = new Room(0, 0, 0, false, false, null, null);


                String[] lines = line.split(",");

                for (int i = 0; i < lines.length; i++) {
                    room.setId(Long.parseLong(lines[0]));
                    room.setNumberOfGuests(Integer.parseInt(lines[1]));
                    room.setPrice(Double.parseDouble(lines[2]));
                    room.setBreakfastIncluded(Boolean.getBoolean(lines[3]));
                    room.setPetsAllowed(Boolean.getBoolean(lines[4]));
                    room.setDateAvailableFrom(new Date());
                    room.setHotel(Hotel.findById(Long.parseLong(lines[6])));
                }
                objectList.add(room);


            }


        } catch (Exception e) {
            System.err.println("Can't read file");
        }


        return objectList;

    }

    public Collection<Room> findRooms(Filter filter) {

        ArrayList<Room> rooms = new ArrayList<>();

        for (Room room : returnRooms()) {
            if (room.getPrice() == filter.getPrice() || room.getNumberOfGuests() == filter.getNumberOfGuests()
                    || room.isBreakfastIncluded() == filter.isBreakfastIncluded() || room.isPetsAllowed() == filter.isPetsAllowed()
                    || room.getDateAvailableFrom().equals(filter.getDateAvailableFrom()) ||
                    room.getHotel().getCountry().equals(filter.getCountry()) || room.getHotel().getCity().equals(filter.getCity())) {
                rooms.add(room);
            }
        }


        return rooms;
    }

    void bookRoom(long roomId, long userId, long hotelId) throws Exception {


        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        Date date = calendar.getTime();


        StringBuffer orderData = new StringBuffer();

        if (validateId(roomId, "C:\\TEMP\\RoomDb.txt"))
            throw new Exception("Room with ID " + roomId + " doesn't exist");
        if (validateId(userId, "C:\\TEMP\\UserDb.txt"))
            throw new Exception("User with ID " + userId + " doesn't exist");
        if (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
            throw new Exception("Hotel with ID " + hotelId + " doesn't exist");

        if (Room.findById(roomId, hotelId).getDateAvailableFrom().compareTo(new Date()) < 0)
            throw new Exception("Room " + roomId + " is not available");


        if ((!validateId(userId, "C:\\TEMP\\UserDb.txt")) && (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
                && (!validateId(roomId, "C:\\TEMP\\RoomDb.txt"))) {

            Order order = new Order(111, User.findById(userId), Room.findById(roomId, hotelId), new Date(),
                    date, Room.findById(roomId, hotelId).getPrice());

            orderData.append(order.getId() + ", ");
            orderData.append(userId + ", ");
            orderData.append(roomId + ", ");
            orderData.append(order.getDateFrom() + ", ");
            orderData.append(order.getDateTo() + ", ");
            orderData.append(order.getMoneyPaid());


            writeDataToFile(orderData, true, "C:\\TEMP\\Order.txt");


        }


    }

    void cancelReservation(long roomId, long userId, long hotelId) throws Exception {

        if (validateId(roomId, "C:\\TEMP\\RoomDb.txt"))
            throw new Exception("Room with ID " + roomId + " doesn't exist");
        if (validateId(userId, "C:\\TEMP\\UserDb.txt"))
            throw new Exception("User with ID " + userId + " doesn't exist");
        if (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
            throw new Exception("Hotel with ID " + hotelId + " doesn't exist");

        if ((!validateId(userId, "C:\\TEMP\\UserDb.txt")) && (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
                && (!validateId(roomId, "C:\\TEMP\\RoomDb.txt"))) {
            Room.findById(roomId, hotelId).setDateAvailableFrom(Room.findById(roomId, hotelId).getDateAvailableFrom());
            delete(Order.findById(userId, roomId, hotelId).getId(), "C:\\TEMP\\Order.txt");

        }


    }


}
