package com.example.springboot.service;

import com.example.springboot.dto.UsersDto;
import com.example.springboot.entity.Users;
import com.example.springboot.exception.ValidationException;
import com.example.springboot.repository.UsersRepo;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class defaultUsersService implements UsersService{

    private final UsersRepo usersRepo;
    private final UsersMapper usersMapper;

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException{
        validateUserDto(usersDto);
        Users savedUser = usersRepo.save(usersMapper.dtoToModel(usersDto));
        return usersMapper.modelToDto(savedUser);
    }

    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if(Objects.isNull(usersDto)){
            throw new ValidationException("Object user is null");
        }
        if(Objects.isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()){
            throw new ValidationException("Login is empty");
        }
    }

    @Override
    public void deleteUser(Integer userId) {
        usersRepo.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = usersRepo.findByLogin(login);
        if(users != null){
            return usersMapper.modelToDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return usersRepo.findAll()
                .stream()
                .map(usersMapper::modelToDto)
                .collect(Collectors.toList());
    }


}
