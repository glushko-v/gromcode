package lesson35.repository;


import lesson35.model.Hotel;
import lesson35.model.Room;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

public class HotelRepositoryNew extends Repository<Hotel> {


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

    public StringBuffer readHotelData(Hotel hotel) {

        StringBuffer hotelData = new StringBuffer();

        hotelData.append(hotel.getId() + "," + " ");
        hotelData.append(hotel.getName() + "," + " ");
        hotelData.append(hotel.getCity() + "," + " ");
        hotelData.append(hotel.getCountry() + "," + " ");
        hotelData.append(hotel.getStreet());


        return hotelData;

    }

//    public Hotel addHotel(Hotel hotel, String path) throws Exception {
//
//        if (!validateId(hotel.getId(), path)) throw new Exception("Hotel with id " + hotel.getId() + " already exists");
//
//
//        writeDataToFile(readHotelData(hotel), true, path);
//
//
//        return hotel;
//    }

    public Hotel findHotelByName(String name) {

        return null;
    }

    @Override
    public Hotel add(Hotel hotel, String path) throws Exception {
        if (!validateId(hotel.getId(), path)) throw new Exception("Hotel with id " + hotel.getId() + " already exists");


        writeDataToFile(readHotelData(hotel), true, path);


        return hotel;
    }

    public Collection<Hotel> returnObjects(String path){

        /*
        1. Считать строку из файла
        2. Преобразовать строку в объект
        3. Добавить объект в коллекцию
        */

        ArrayList<Hotel> objectList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))){
            String line;

            while((line = br.readLine()) != null){

                Hotel hotel = new Hotel(0, null, null, null, null);


                String[] lines = line.split(",");

                for (int i = 0; i <lines.length; i++) {
                    hotel.setId(Long.parseLong(lines[0]));
                    hotel.setName(lines[1]);
                    hotel.setCountry(lines[3]);
                    hotel.setCity(lines[2]);
                    hotel.setStreet(lines[4]);
                }
                objectList.add(hotel);




            }


        }
        catch (Exception e){
            System.err.println("Can't read file");
        }





        
        return objectList;

    }


}
