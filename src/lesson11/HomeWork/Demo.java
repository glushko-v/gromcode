package lesson11.HomeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room hiltonRoom = new Room(123, 250, 2, new Date(), "Hilton", "Kiev");
        Room hyattRoom = new Room(321, 300, 4, new Date(), "Hyatt", "Kiev");
        Room swissotelRoom = new Room(444, 200, 3, new Date(), "Swissotel", "Kiev");
        Room ibisRoom = new Room(578, 150, 2, new Date(), "Ibis", "Kiev");
        Room swissotelRoom1 = new Room(478, 200, 3, new Date(), "Swissotel", "Kiev");

        Room[] rooms = new Room[10];

        rooms[1] = hiltonRoom;
        rooms[2] = hyattRoom;
        rooms[3] = swissotelRoom;
        rooms[4] = ibisRoom;
        rooms[5] = swissotelRoom1;

        Room hiltonRoom1 = new Room(123, 250, 2, new Date(), "Hilton", "Odessa");
        Room hyattRoom1 = new Room(321, 300, 4, new Date(), "Hyatt", "Kiev");
        Room swissotelRoom2 = new Room(444, 200, 3, new Date(), "Swissotel", "Odessa");
        Room ibisRoom1 = new Room(578, 150, 2, new Date(), "Ibis", "Kiev");
        Room swissotelRoom3 = new Room(478, 200, 3, new Date(), "Swissotel", "Odessa");

        Room[] rooms1 = new Room[10];

        rooms1[1] = hiltonRoom1;
        rooms1[2] = hyattRoom1;
        rooms1[3] = swissotelRoom2;
        rooms1[4] = ibisRoom1;
        rooms1[5] = swissotelRoom3;

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        BookingComAPI bookingComAPI = new BookingComAPI(rooms1);
        API[] apis = new API[10];
        apis[1] = googleAPI;
        apis[2] = bookingComAPI;
        Controller controller = new Controller(apis);
        System.out.println(Arrays.deepToString(googleAPI.getAll()));
        System.out.println(Arrays.deepToString(bookingComAPI.getAll()));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(200, 3, "Kiev", "Swissotel")));
        System.out.println();
        System.out.println(Arrays.deepToString(controller.check(googleAPI, bookingComAPI)));


    }
}
