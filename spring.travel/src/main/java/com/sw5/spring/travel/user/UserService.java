package com.sw5.spring.travel.user;

import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(String username, String email, String password) {
        final UUID id = UUID.randomUUID();
        User user = new User(id, username, email, password);

        return user;
    }
}
