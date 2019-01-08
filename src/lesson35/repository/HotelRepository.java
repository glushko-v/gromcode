package lesson35.repository;


import lesson35.model.Hotel;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HotelRepository extends Repository<Hotel> {


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

        Hotel hotel = new Hotel(0, null, null, null, null);
        StringBuffer content = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\HotelDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(",");
                for (int i = 0; i < lines.length; i++) {
                    content.append(lines[i] + ",");
                }


            }

            String dataString = content.toString();
            dataString = dataString.trim();
            String[] hotels = dataString.split(",");

            for (int i = 1; i < hotels.length; i += 5) {
                if (hotels[i].equals(" " + name)) {
                    hotel.setId(Long.parseLong(hotels[i - 1]));
                    hotel.setName(hotels[i]);
                    hotel.setCity(hotels[i + 1]);
                    hotel.setCountry(hotels[i + 2]);
                    hotel.setStreet(hotels[i + 3]);

                }

            }


        } catch (IOException e) {
            System.err.println("Can't read file");
        }


        return hotel;



    }



    @Override
    public Hotel add(Hotel hotel, String path) throws Exception {
        if (!validateId(hotel.getId(), path)) throw new Exception("Hotel with id " + hotel.getId() + " already exists");


        writeDataToFile(readHotelData(hotel), true, path);


        return hotel;
    }


    public List<Hotel> returnHotels() {


        ArrayList<Hotel> objectList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\HotelDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                Hotel hotel = new Hotel(0, null, null, null, null);


                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {
                    hotel.setId(Long.parseLong(lines[0]));
                    hotel.setName(lines[1]);
                    hotel.setCountry(lines[3]);
                    hotel.setCity(lines[2]);
                    hotel.setStreet(lines[4]);
                }
                objectList.add(hotel);


            }


        } catch (Exception e) {
            System.err.println("Can't read file");
        }


        return objectList;

    }

    public List<Hotel> findHotelByCity(String city){

        ArrayList<Hotel> hotelsByCity = new ArrayList<>();



        for (Hotel hotel: returnHotels()) {
            if (hotel.getCity().equals(city)){
                hotelsByCity.add(hotel);
            }
        }


        return hotelsByCity;
    }

    public List<Hotel> findByName(String name) {

        ArrayList<Hotel> hotelsByName = new ArrayList<>();

        for (Hotel hotel: returnHotels()) {
            if (hotel.getName().equals(name)){
                hotelsByName.add(hotel);
            }
        }

        return hotelsByName;
    }


}
