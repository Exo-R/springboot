package com.example.springboot.service;

import com.example.springboot.dto.UsersDto;
import com.example.springboot.entity.Users;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper implements UsersMapperImpl{
    @Override
    public UsersDto modelToDto(Users users) {
        return UsersDto.builder()
                .id(users.getId())
                .email(users.getEmail())
                .login(users.getLogin())
                .name(users.getName())
                .build();
    }

    @Override
    public Users dtoToModel(UsersDto usersDto) {
        Users user = new Users();
        user.setId(usersDto.getId());
        user.setEmail(usersDto.getEmail());
        user.setName(usersDto.getName());
        user.setLogin(usersDto.getLogin());
        return user;
    }
}
