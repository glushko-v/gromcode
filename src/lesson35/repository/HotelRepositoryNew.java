package lesson35.repository;


import lesson35.model.Hotel;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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




}
