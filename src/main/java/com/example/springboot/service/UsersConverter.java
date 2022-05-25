package com.example.springboot.service;

import com.example.springboot.dto.UsersDto;
import com.example.springboot.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersConverter {

    public Users fromUserDtoToUser(UsersDto userDto){
        Users user = new Users();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setName(userDto.getName());
        user.setLogin(userDto.getLogin());
        return user;
    }

    public UsersDto fromUserToUserDto(Users user){
        return UsersDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .login(user.getLogin())
                .name(user.getName())
                .build();
    }

}
