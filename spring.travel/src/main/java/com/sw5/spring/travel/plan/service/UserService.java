package com.sw5.spring.travel.plan.service;

import com.sw5.spring.travel.plan.dto.UserDto;
import com.sw5.spring.travel.plan.dto.UserLoginDto;
import javassist.NotFoundException;

public interface UserService {
    String login(UserLoginDto loginDto);
    UserDto findOneUser(String userName) throws NotFoundException;
    public String saveUser(UserDto userDto);
}
