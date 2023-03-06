package com.sw5.spring.travel.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByName(String userName);
    Optional<User> findByEmail(String email);
}
