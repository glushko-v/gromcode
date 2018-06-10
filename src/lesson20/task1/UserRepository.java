package lesson20.task1;

import lesson20.task1.exception.BadRequestException;
import lesson20.task1.exception.InternalServerException;
import lesson20.task1.exception.UserNotFoundException;

public class UserRepository {
    private User[] users;

    public UserRepository(User[] users) {
        this.users = users;
    }

    public int countUsers() {
        int count = 0;
        for (User user : users) {
            if (user != null) count++;
        }
        return count;
    }


    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String[] names = new String[countUsers()];

        int index = 0;
        for (User user : users) {
            if (user != null) {
                names[index] = user.getName();
            }
        }
        return names;

    }


    public long[] getUserIds() {
        long[] ids = new long[countUsers()];

        int index = 0;
        for (User user : users) {
            if (user != null) ids[index] = user.getId();
        }

        return ids;
    }


    public String getUserNameById(long id) {
        int index = 0;
        String name = null;
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) name = user.getName();
            }

        }
        return name;


    }

    public User getUserByName(String name) {

        for (User user : users) {
            if (user != null) {
                if (user.getName() == name) return user;

            }

        }
        return null;
    }


    public User findById(long id) throws UserNotFoundException {

        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) return user;
            }

        }

        throw new UserNotFoundException("User with ID " + id + " not found");


    }

    public User getUserBySessionId(String sessionId) {

        for (User user : users) {
            if (user != null) {
                if (user.getSessionId() == sessionId) return user;
            }

        }
        return null;
    }

    public User save(User user) throws Exception {
        if (user == null) throw new BadRequestException("Can't save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with ID " + user.getId()
                    + " already exists");
        } catch (UserNotFoundException e) {
            System.out.println("User with ID " + user.getId() + " not found. Will be saved");
        }

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }

        }
        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
    }


    public User update(User user) throws Exception {
        if (user == null) throw new BadRequestException("Can't update null user");

        findById(user.getId());
        int index = 0;

        for (User us: users) {
            if (us != null && us.getId() == user.getId()){
                users[index] = user;
                return users[index];
            }
            index++;
        }

        throw new InternalServerException("Unexpected error");
    }


    public void delete(long id) throws Exception {

        findById(id);


        int index = 0;

        for (User us: users) {
           if(us.getId() == id){
               users[index] = null;
               break;
           }
           index++;
        }


    }

}


