package com.example.springboot.service;

import com.example.springboot.dto.UsersDto;
import com.example.springboot.entity.Users;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import java.util.List;

@Mapper(componentModel = "spring")
public interface UsersMapperImpl {

    UsersDto modelToDto(Users users);

    //List<UsersDto> modelToDtos(List<Users> users);

    @InheritInverseConfiguration
    Users dtoToModel(UsersDto usersDto);

}
