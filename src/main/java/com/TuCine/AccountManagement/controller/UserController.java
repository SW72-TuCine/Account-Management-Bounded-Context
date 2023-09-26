package com.TuCine.AccountManagement.controller;

import com.TuCine.AccountManagement.domain.communication.LoginRequest;
import com.TuCine.AccountManagement.domain.communication.RegisterRequest;
import com.TuCine.AccountManagement.resource.TypeUserDto;
import com.TuCine.AccountManagement.resource.UserDto;
import com.TuCine.AccountManagement.shared.exception.ValidationException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import com.TuCine.AccountManagement.service.UserService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/TuCine/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    public UserController(UserService userService) { this.userService = userService; }

    //URL: http://localhost:8080/api/TuCine/v1/users
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/{userId}
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("{userId}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("userId") Long userId){
        return new ResponseEntity<>(userService.getById(userId), HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/{id}/typeUser
    //Method: GET
    @Transactional(readOnly = true)
    @GetMapping("{userId}/typeUser")
    public ResponseEntity<TypeUserDto> getTypeUserByUserId(@PathVariable("userId") Long id) {
        TypeUserDto typeUserDto = userService.getTypeUserById(id);
        if (typeUserDto == null) {
            return ResponseEntity.notFound().build();
        }
        return new ResponseEntity<>(typeUserDto, HttpStatus.OK);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/auth/sign-up
    //Method: POST
    @PostMapping("/auth/sign-up")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest request) {
        return userService.register(request);
    }

    //URL: http://localhost:8080/api/TuCine/v1/users/auth/sign-in
    //Method: POST
    @PostMapping("/auth/sign-in")
    public ResponseEntity<?> loginUser(@Valid @RequestBody LoginRequest request) {
        return userService.login(request);
    }

}
