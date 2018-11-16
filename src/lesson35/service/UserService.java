package lesson35.service;

import lesson35.repository.UserRepository;
import lesson35.model.User;

public class UserService {

    private UserRepository userRepository = new UserRepository();

    public User registerUser (User user) throws Exception {
        // check business logic:
        //1. no empty fields
        //2. 18+ age

        //if logic ok:

        return userRepository.registerUser(user, "C:\\TEST\\UserDb.txt");
    }
}
