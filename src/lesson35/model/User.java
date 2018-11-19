package lesson35.model;

import lesson35.UserType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class User {
    private long id;
    private String userName;
    private String password;
    private String country;
    private UserType userType;

    public User(long id, String userName, String password, String country, UserType userType) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.country = country;
        this.userType = userType;
    }

    public long getId() {
        return id;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public static User user1 = new User(111, "John", "112233", "USA", UserType.USER);
    public static User user2 = new User(222, "Alex", "0000", "Belarus", UserType.ADMIN);
    public static User user3 = new User(222, "Vlad", "98765231", "Ukraine", UserType.USER);



    public static User findById(long id) {
        StringBuffer userInfo = new StringBuffer();
        User user = new User(0, null, null, null, null);


        try (BufferedReader br = new BufferedReader(new FileReader("C:\\TEST\\UserDb.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {

                String[] lines = line.split(", ");

                for (int i = 0; i < lines.length; i++) {

                    if (id == Long.parseLong(lines[0])) {
                        userInfo.append(lines[0] + ", ");
                        userInfo.append(lines[1] + ", ");
                        userInfo.append(lines[2] + ", ");
                        userInfo.append(lines[3] + ", ");
                        userInfo.append(lines[4]);
                    }

                    break;



                }

            }
        } catch (IOException e) {
            System.err.println("Can't read file");
        }

        String userString = userInfo.toString();

        String[] userData = userString.split(",");

        for (int i = 0; i <userData.length; i++) {

            user.setId(Long.parseLong(userData[0]));
            user.setUserName(userData[1]);
            user.setPassword(userData[2]);
            user.setCountry(userData[3]);
            user.setUserType(UserType.valueOf(userData[4]));

        }


        return user;
    }



}
