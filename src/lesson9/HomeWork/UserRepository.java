package lesson9.HomeWork;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }


    public User[] getUsers() {
        return users;
    }

    public User[] getUserNames() {
        for (User names : users) {
            User name = names;
        }

        return users;
    }

    public User[] getUserIds() {
        for (User ids : users) {
            User id = ids;
        }
        return users;
    }


}
