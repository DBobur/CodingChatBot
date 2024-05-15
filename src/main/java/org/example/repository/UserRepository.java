package org.example.repository;

import org.example.model.User;

public class UserRepository extends BaseRepository<User> {
    {
        path = "src/main/resources/users.json";
    }
}
