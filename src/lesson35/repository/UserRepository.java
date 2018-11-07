package lesson35.repository;

import lesson35.model.User;

public class UserRepository {

    //считывание данных - считывание файла
    //обработка данных - маппинг данных

    public User registerUser (User user){
        //save user to Db (file)
        // через сеттер

        return user;
    }

    void login (String userName, String password){
        //1. считываем с консоли имя пользователя
        //2. пробегаемся по массиву имен пользователя и ищем совпадение
        //3. считываем с коносоли пароль
        //4. пробегаемся по массиву паролей и ищем совпадение
        //3. если логин и пароль совпадают, то выводим "Login is successful"
        //4. передаем логин и id юзера???
    }


}
