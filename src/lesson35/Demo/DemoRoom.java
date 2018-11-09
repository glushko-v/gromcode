package lesson35.Demo;

import lesson35.model.Room;
import lesson35.repository.RoomRepository;

import java.util.Date;

import static lesson35.model.Room.date1;

public class DemoRoom {
    public static void main(String[] args) {

        RoomRepository roomRepository = new RoomRepository();

        System.out.println(Room.sdf.format(date1));



    }
}
