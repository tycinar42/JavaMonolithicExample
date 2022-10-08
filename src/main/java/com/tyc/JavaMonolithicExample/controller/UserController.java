package com.tyc.JavaMonolithicExample.controller;

import com.tyc.JavaMonolithicExample.dto.request.SaveUserRequestDto;
import com.tyc.JavaMonolithicExample.repository.entity.EUserGender;
import com.tyc.JavaMonolithicExample.repository.entity.EUserType;
import com.tyc.JavaMonolithicExample.repository.entity.User;
import com.tyc.JavaMonolithicExample.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.tyc.JavaMonolithicExample.constant.EndPoint.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(USER)
public class UserController {
    private final UserService service;

    @GetMapping(SAVE)
    public ResponseEntity<User> save (String name, String surname, String email, String password, String telephone, EUserGender userGender) {
        User user = User.builder()
                .name(name)
                .surname(surname)
                .email(email)
                .password(password)
                .telephone(telephone)
                .userGender(userGender)
                .build();
        return ResponseEntity.ok(service.save(user));
    }

    @GetMapping(SAVEDTO)
    public ResponseEntity<User> save(SaveUserRequestDto requestDto) {
        return ResponseEntity.ok(service.save(requestDto));
    }

    @GetMapping(FINDALL)
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
}
