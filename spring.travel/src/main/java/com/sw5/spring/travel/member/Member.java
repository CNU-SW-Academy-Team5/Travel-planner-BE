package com.sw5.spring.travel.member;

import java.util.UUID;

public class Member {
    private final UUID id;
    private final String email;

    public Member(UUID id, String email) {
        this.id = id;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public UUID getId() {
        return id;
    }
}
