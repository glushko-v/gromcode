package lesson35.Demo;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;

import java.io.FileNotFoundException;

public class DemoHotel {

    public static void main(String[] args) throws Exception {

        Hotel hotel = new Hotel(111, "Hilton", "Ukraine", "Kiev", "Shevchevnko");
        Hotel hotel1 = new Hotel(222, "Ibis", "Belgium", "Brussels", "Unknown");
        Hotel hotel2 = new Hotel(333, "4Seasons", "Spain", "Madrid", "test");

        HotelRepository hotelRepository = new HotelRepository();

//        hotelRepository.addHotel(hotel);
//        hotelRepository.addHotel(hotel1);
//        hotelRepository.addHotel(hotel2);




    }
}
