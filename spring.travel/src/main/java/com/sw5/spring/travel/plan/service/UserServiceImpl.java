package com.sw5.spring.travel.plan.service;

import com.sw5.spring.travel.domain.user.User;
import com.sw5.spring.travel.domain.user.UserRepository;
import com.sw5.spring.travel.plan.converter.UserConverter;
import com.sw5.spring.travel.plan.dto.UserDto;
import com.sw5.spring.travel.plan.dto.UserLoginDto;
import javassist.NotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    public UserServiceImpl(UserRepository userRepository, UserConverter userConverter) {
        this.userRepository = userRepository;
        this.userConverter = userConverter;
    }

    @Transactional
    @Override
    public String login(UserLoginDto loginDto) {
        User user = userRepository.findById(loginDto.getEmail()).orElse(null);
        if(user.getPassword().equals(loginDto.getPassword())){
            return user.getId();
        }
        return null;
    }

    public String saveUser(UserDto userDto){
        User user = userConverter.convertUser(userDto);
        User entity = userRepository.save(user);
        return entity.getId();
    }

    @Transactional
    @Override
    public UserDto findOneUser(String userName) throws NotFoundException {
        return userRepository.findByName(userName)
                .map(userConverter::convertUserDto)
                .orElseThrow(() -> new NotFoundException("cannot find user"));
    }
}
