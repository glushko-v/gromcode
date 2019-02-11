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
