package gromcode.main.lesson13;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        UserRepository userRepository = new UserRepository();

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        User user = new User(3521, "Ann", "13216");
        userRepository.save(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        //сохранение юзера
        //сохранение того же юзера
        //когда нет места в массиве
        //когда сохраняем null

//        int n = 15;
//        while (n > 0){
//            User user1 = new User(n, "Ann", "13216");
//            Sys.out.println(userRepository.save(user1));
//
//            n--;
//        }
//        Sys.out.println(Arrays.deepToString(userRepository.getUsers()));

        userRepository.save(null);

        // test update

        user = new User(3521, "Ann", "dfdfoeed");
        userRepository.update(user);

        System.out.println(Arrays.deepToString(userRepository.getUsers()));

        user = new User(521, "Ann", "dfdfoeed");
        System.out.println(userRepository.update(user));
        System.out.println(userRepository.update(null));
        System.out.println(Arrays.deepToString(userRepository.getUsers()));






        //обновление юзера
        //обновление null
        //нет юзера на обновление

    }
}
