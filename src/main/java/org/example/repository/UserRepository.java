package org.example.repository;

import org.example.model.User;

import java.io.File;
import java.io.IOException;

public class UserRepository extends BaseRepository<User> {
    {
        path = "src/main/resources/json/users.json";
    }

    @Override
    public User add(User user) {
        File file = new File("src/main/resources/user/"+user.getUsername());
        try {
            file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return super.add(user);
    }
}
