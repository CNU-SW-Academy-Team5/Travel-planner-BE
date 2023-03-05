package com.sw5.spring.travel.plan.converter;

import com.sw5.spring.travel.domain.user.User;
import com.sw5.spring.travel.plan.dto.UserDto;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {
    //dto -> entity
    public User convertUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto convertUserDto(User user){
        UserDto userDto = UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();

        return userDto;
    }
}
