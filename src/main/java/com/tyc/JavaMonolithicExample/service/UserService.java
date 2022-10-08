package com.tyc.JavaMonolithicExample.service;

import com.tyc.JavaMonolithicExample.dto.request.SaveUserRequestDto;
import com.tyc.JavaMonolithicExample.mapper.IUserMapper;
import com.tyc.JavaMonolithicExample.repository.IUserRepository;
import com.tyc.JavaMonolithicExample.repository.entity.User;
import com.tyc.JavaMonolithicExample.utility.ServiceManager;
import org.springframework.stereotype.Service;

@Service
public class UserService extends ServiceManager<User, Long> {
    private final IUserRepository userRepository;

    public UserService(IUserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
    }

    public User save(SaveUserRequestDto requestDto) {
        User user = IUserMapper.INSTANCE.toUser(requestDto);
        return userRepository.save(user);
    }

    public Boolean isExistUser(String username, String password) {
        return userRepository.isExistUser(username, password);
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
