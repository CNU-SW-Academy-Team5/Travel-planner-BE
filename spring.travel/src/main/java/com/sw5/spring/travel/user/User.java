package com.sw5.spring.travel.user;

import java.util.UUID;

public class User {
    private UUID id;
    private String email;
    private String username;
    private String password;

    public User(UUID id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
