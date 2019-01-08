package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

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


//    Room addRoom(Room room, String path) throws Exception {
//
//        if (!validateId(room.getId(), path)) throw new Exception("Room with id " + room.getId() + " already exists");
//
//
//        writeDataToFile(readRoomData(room), true, path);
//
//
//
//        return room;
//    }

    @Override
    public Room add(Room room, String path) throws Exception {
        if (!validateId(room.getId(), path)) throw new Exception("Room with id " + room.getId() + " already exists");


        writeDataToFile(readRoomData(room), true, path);



        return room;
    }

    public List<Room> returnRooms(){




        ArrayList<Room> objectList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\RoomDb.txt"))){
            String line;

            while((line = br.readLine()) != null){

                Room room = new Room(0, 0, 0, false, false, null, null);


                String[] lines = line.split(",");

                for (int i = 0; i <lines.length; i++) {
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


        }
        catch (Exception e){
            System.err.println("Can't read file");
        }






        return objectList;

    }

    public Collection<Room> findRooms(Filter filter){

        ArrayList<Room> rooms = new ArrayList<>();



        /*
        1. Создаем коллекцию
        2. Если поле не равно null добавляем в коллекцию
        3. Возвращаем коллекцию
        */


        return null;
    }








}
