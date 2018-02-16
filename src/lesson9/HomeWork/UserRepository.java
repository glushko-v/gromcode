package lesson9.HomeWork;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] userNames = {"John", "Jack", "Dan", "Bill", "Hannah"};
        return userNames;

    }

    public long[] getUserIds(){
        long[] userIds = {5648, 98751, 112, 3654, 882};
        return userIds;
    }

    


}
