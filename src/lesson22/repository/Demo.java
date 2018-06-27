package lesson22.repository;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

//        UserRepository userRepository = new UserRepository();

        User user1 = new User(1001, "Daniil", "dsfsdgw1314wg");
        User user3 = new User(1001, "Test", "dsfsdgw1314wg");
        User user2 = new User(1002, "Andrey", "23424dsklf");


        UserRepository.save(user1);
        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));



        System.out.println(Arrays.deepToString(UserRepository.getUsers()));



    }
}
