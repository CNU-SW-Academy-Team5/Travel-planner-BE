package com.sw5.spring.travel.user;

import java.util.UUID;

public class User {
    private final UUID id;
    private final String email;
    private final String username;
    private final String password;

    public User(UUID id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }

    public UUID getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
