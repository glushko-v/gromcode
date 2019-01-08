package lesson35.Demo;

import lesson35.repository.HotelRepository;


public class DemoHotel {

    public static void main(String[] args) throws Exception {



        HotelRepository hotelRepository = new HotelRepository();
//        System.out.println((hotelRepository.returnHotels().get(0)));
//        System.out.println(hotelRepository.findHotelByCity("Istanbul"));
        System.out.println(hotelRepository.findByName("Ibis"));
















    }
}
