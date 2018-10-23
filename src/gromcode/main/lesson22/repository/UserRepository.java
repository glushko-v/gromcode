package gromcode.main.lesson22.repository;

public class UserRepository {
    private static User[] users = new User[10];

//    public UserRepository(User[] users) {
//        this.users = users;
//    }

    public static int countUsers() {
        int count = 0;
        for (User user : users) {
            if (user != null) count++;
        }
        return count;
    }


    public static User[] getUsers() {
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


    public static long[] getUserIds() {
        long[] ids = new long[countUsers()];

        int index = 0;
        for (User user : users) {
            if (user != null) ids[index] = user.getId();
        }

        return ids;
    }


    public static String getUserNameById(long id) {
        int index = 0;
        String name = null;
        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) name = user.getName();
            }

        }
        return name;


    }

    public static User getUserByName(String name) {

        for (User user : users) {
            if (user != null) {
                if (user.getName() == name) return user;

            }

        }
        return null;
    }


    public static User findById(long id) {

        for (User user : users) {
            if (user != null) {
                if (user.getId() == id) return user;
            }

        }
        return null;
    }

    public static User getUserBySessionId(String sessionId) {

        for (User user : users) {
            if (user != null) {
                if (user.getSessionId() == sessionId) return user;
            }

        }
        return null;
    }

    public static User save(User user) {
        if (user == null) return null;
        if (findById(user.getId()) != null) return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == null) {
                users[i] = user;
                return user;
            }

        }
        return null;
    }


    public static User update(User user) {
        if (user == null) return null;

        for (int i = 0; i < users.length; i++) {
            if (users[i] == findById(user.getId())) {
                users[i] = user;
                return users[i];
            } else return null;

        }

        return null;
    }


    public static void delete(long id) {
        for (int i = 0; i < users.length; i++) {
            if (users[i] == findById(id)) users[i] = null;
        }


    }

}


