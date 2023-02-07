package com.sw5.spring.travel.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.UUID;

@ToString
@Getter
@Entity
@NoArgsConstructor
public class User {

    @Id
    @Column
    private UUID id;

    @Column
    private String email;

    @Column
    private String username;

    @Column
    private String password;

    @Builder
    public User(UUID id, String email, String username, String password) {
        this.id = id;
        this.email = email;
        this.username = username;
        this.password = password;
    }
}
