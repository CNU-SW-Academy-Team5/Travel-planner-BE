package com.sw5.spring.travel.user;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    User insert(User user){
        return user;
    }
}
