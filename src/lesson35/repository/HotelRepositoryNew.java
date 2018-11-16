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

    @Override
    public Hotel findById(long id, String path) {
        Hotel hotel = new Hotel(0, null, null, null, null);

        StringBuffer hotelInfo = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {

                    if (id == Long.parseLong(lines[0])) {
                        hotelInfo.append(lines[0] + ", ");
                        hotelInfo.append(lines[1] + ", ");
                        hotelInfo.append(lines[2] + ", ");
                        hotelInfo.append(lines[3] + ", ");
                        hotelInfo.append(lines[4]);
                    }

                    break;


                }

            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }

        String hotelString = hotelInfo.toString();

        String[] hotelData = hotelString.split(",");

        for (int i = 0; i < hotelData.length; i++) {

            hotel.setId(Long.parseLong(hotelData[0]));
            hotel.setName(hotelData[1]);
            hotel.setCountry(hotelData[2]);
            hotel.setCity(hotelData[3]);
            hotel.setStreet(hotelData[4]);

        }

        return hotel;
    }
}
