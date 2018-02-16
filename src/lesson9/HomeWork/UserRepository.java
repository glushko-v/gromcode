package lesson9.HomeWork;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUsernames() {
        String[] userNames = {"John", "Jack", "Dan", "Bill", "Hannah"};
        return userNames;

    }


}
