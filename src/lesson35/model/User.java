package lesson35.model;

import lesson35.UserType;

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

    public static User user1 = new User(111, "John", "112233", "USA", UserType.USER);
    public static User user2 = new User(222, "Alex", "0000", "Belarus", UserType.ADMIN);
    public static User user3 = new User(222, "Vlad", "98765231", "Ukraine", UserType.USER);

}
