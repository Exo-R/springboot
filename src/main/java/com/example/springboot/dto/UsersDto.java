package com.example.springboot.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersDto {

    private int id;
    private String name;
    private String login;
    private String email;

}
