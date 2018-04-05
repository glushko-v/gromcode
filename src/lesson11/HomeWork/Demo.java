package lesson11.HomeWork;

import java.util.Arrays;
import java.util.Date;

public class Demo {
    public static void main(String[] args) {
        Room hiltonRoom = new Room(123, 250, 2, new Date(), "Hilton", "Kiev");
        Room hyattRoom = new Room(321, 300, 4, new Date(), "Hyatt", "Kiev");
        Room swissotelRoom = new Room(444, 200, 3, new Date(), "Swissotel", "Kiev");
        Room ibisRoom = new Room(578, 150, 2, new Date(), "Ibis", "Kiev");

        Room[] rooms = new Room[10];

        rooms[1] = hiltonRoom;
        rooms[2] = hyattRoom;
        rooms[3] = swissotelRoom;
        rooms[4] = ibisRoom;

        GoogleAPI googleAPI = new GoogleAPI(rooms);
        System.out.println(Arrays.deepToString(googleAPI.getAll()));
        System.out.println(Arrays.deepToString(googleAPI.findRooms(200,3, "Kiev", "Swissotel")));


    }
}
