package lesson35.repository;

import lesson35.model.Filter;
import lesson35.model.User;

import java.util.ArrayList;

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
        //1. ищем совпадения по id в базе юзеров+++
        //1.1 при совпадении забираем из файла соответствующего юзера
        //2. ищем совпадения по id в базе отелей+++
        //2.1 при совпадении забираем из файла соответствующий отель
        //3. ищем совпадения по id в базе комнат+++
        //3.1 при совпадении забираем из файла соответствующую комнту
        //4. проверяем у комнаты DateAvailableFrom
        //5. если комната не занята, используем setDateAvailableFrom

        if (validateId(roomId, "C:\\TEMP\\RoomDb.txt"))
            throw new Exception("Room with ID " + roomId + " doesn't exist");
        if (validateId(userId, "C:\\TEMP\\UserDb.txt"))
            throw new Exception("User with ID " + userId + " doesn't exist");
        if (validateId(hotelId, "C:\\TEMP\\HotelDb.txt"))
            throw new Exception("Hotel with ID " + hotelId + " doesn't exist");




    }

    ArrayList<Filter> findRooms(Filter filter){



        return null;
    }



}
