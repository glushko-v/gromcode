package lesson35.Demo;

import lesson35.model.Hotel;
import lesson35.repository.HotelRepository;
import lesson35.repository.HotelRepositoryNew;

import java.io.FileNotFoundException;
import java.util.Arrays;

public class DemoHotel {

    public static void main(String[] args) throws Exception {



        HotelRepositoryNew hotelRepositoryNew = new HotelRepositoryNew();
//        System.out.println((hotelRepositoryNew.returnObjects("C:\\TEST\\HotelDb.txt"));
        hotelRepositoryNew.findHotelByName("lala");


//        hotelRepository.addHotel(hotel);
//        hotelRepository.addHotel(hotel1);
//        hotelRepository.addHotel(hotel2);










    }
}
