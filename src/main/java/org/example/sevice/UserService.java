package org.example.sevice;

import org.example.excaption.DataNotFoundExcaption;
import org.example.model.User;
import org.example.repository.UserRepository;

public class UserService extends BaseService<User, UserRepository> {
    private UserService() {
        super(new UserRepository());
    }
    private static final UserService userService = new UserService();
    public static final UserService getInstance(){
        return userService;
    }
    public User login(long chatId){
        return getAll().stream().filter(user -> user.getChatId().equals(chatId)).findAny().orElseThrow(
                () -> new DataNotFoundExcaption("Data not found")
        );
    }
}
