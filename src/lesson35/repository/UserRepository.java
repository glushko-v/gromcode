package lesson35.repository;


import lesson35.UserType;
import lesson35.model.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class UserRepository extends Repository<User> {


    public User registerUser(User user, String path) throws Exception {
        return add(user, path);
    }

    public StringBuffer readUserData(User user) {

        StringBuffer userData = new StringBuffer();

        userData.append(user.getId() + "," + " ");
        userData.append(user.getUserName() + "," + " ");
        userData.append(user.getPassword() + "," + " ");
        userData.append(user.getCountry() + "," + " ");
        userData.append(user.getUserType());


        return userData;

    }

    void login(String userName, String password) {


    }

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

    @Override
    public User add(User user, String path) throws Exception {
        if (!validateId(user.getId(), path)) throw new Exception("User with id " + user.getId() + " already exists");


        writeDataToFile(readUserData(user), true, path);


        return user;
    }

    void bookRoom(long roomId, long userId, long hotelId) throws Exception {
        /*1. ищем совпадения по id в базе юзеров+++
        1.1 при совпадении забираем из файла соответствующего юзера++
        2. ищем совпадения по id в базе отелей+++
        2.1 при совпадении забираем из файла соответствующий отель++
        3. ищем совпадения по id в базе комнат+++
        3.1 при совпадении забираем из файла соответствующую комнату++
        4. проверяем у комнаты DateAvailableFrom
        5. если комната не занята, используем setDateAvailableFrom
        6. создаем объект класса Order+++
        7. записываем ордер в файл+++
        8. перезаписываем DateAvailableFrom*/

        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH, 3);
        Date date = calendar.getTime();


        StringBuffer orderData = new StringBuffer();

        if (validateId(roomId, "C:\\TEMP\\RoomDb.txt"))
            throw new Exception("Room with ID " + roomId + " doesn't exist");
        if (validateId(userId, "C:\\TEMP\\UserDb.txt"))
            throw new Exception("User with ID " + userId + " doesn't exist");
        if (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
            throw new Exception("Hotel with ID " + hotelId + " doesn't exist");

        if (Room.findById(roomId, hotelId).getDateAvailableFrom().compareTo(new Date()) < 0)
            throw new Exception("Room " + roomId + " is not available");


        if ((!validateId(userId, "C:\\TEMP\\UserDb.txt")) && (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
                && (!validateId(roomId, "C:\\TEMP\\RoomDb.txt"))) {

            Order order = new Order(111, User.findById(userId), Room.findById(roomId, hotelId), new Date(),
                    date, Room.findById(roomId, hotelId).getPrice());

            orderData.append(order.getId() + ", ");
            orderData.append(userId + ", ");
            orderData.append(roomId + ", ");
            orderData.append(order.getDateFrom() + ", ");
            orderData.append(order.getDateTo() + ", ");
            orderData.append(order.getMoneyPaid());


            writeDataToFile(orderData, true, "C:\\TEMP\\Order.txt");


        }


    }

    void cancelReservation(long roomId, long userId, long hotelId) throws Exception {
        /*
        1. Проверяем id комнаты++
        2. Проверяем id юзера ++
        3. если совпадения, то
        3.1 устанавливаем dateAvailableFrom на начальную дату++
        3.2 удаляем ордер из файла:
        3.2.1 Ищем совпадения по id юзера и комнаты
        3.2.2 Удаляем соответствующую строку

        */
        if (validateId(roomId, "C:\\TEMP\\RoomDb.txt"))
            throw new Exception("Room with ID " + roomId + " doesn't exist");
        if (validateId(userId, "C:\\TEMP\\UserDb.txt"))
            throw new Exception("User with ID " + userId + " doesn't exist");
        if (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
            throw new Exception("Hotel with ID " + hotelId + " doesn't exist");

        if ((!validateId(userId, "C:\\TEMP\\UserDb.txt")) && (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
                && (!validateId(roomId, "C:\\TEMP\\RoomDb.txt"))) {
            Room.findById(roomId, hotelId).setDateAvailableFrom(Room.findById(roomId, hotelId).getDateAvailableFrom());
            delete(Order.findById(userId, roomId, hotelId).getId(), "C:\\TEMP\\Order.txt");

        }


    }

    public List<User> returnUsers() {


        ArrayList<User> objectList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\UserDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                User user = new User(0, null, null, null, null);


                String[] lines = line.split(",");

                for (int i = 0; i < lines.length; i++) {
                    user.setId(Long.parseLong(lines[0]));
                    user.setUserName(lines[1]);
                    user.setPassword(lines[2]);
                    user.setCountry(lines[3]);
                    user.setUserType(UserType.valueOf(lines[4]));
                }
                objectList.add(user);


            }


        } catch (Exception e) {
            System.err.println("Can't read file");
        }


        return objectList;

    }

}
