package com.TuCine.AccountManagement.service;

import com.TuCine.AccountManagement.domain.communication.RegisterRequest;
import com.TuCine.AccountManagement.resource.TypeUserDto;
import com.TuCine.AccountManagement.resource.UserDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {
    List<UserDto> getAllUsers();
    UserDto getById(Long userId);

    TypeUserDto getTypeUserById(Long id);

    //UserDto registerUser(UserDto userDto);

    boolean existsByUserEmail (String email);

    boolean existsUserByDni(String Dni);

    ResponseEntity<?> register(RegisterRequest request);
}
