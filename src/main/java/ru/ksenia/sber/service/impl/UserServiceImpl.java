package ru.ksenia.sber.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.ksenia.sber.dto.UserDto;
import ru.ksenia.sber.repository.UserRepository;
import ru.ksenia.sber.service.UserService;

import java.util.Date;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto getUserDataById(Long userId) {
        Optional<UserDto> userDto = userRepository.getUserDataById(userId);

        return userDto.orElse(buildDefaultUser());
    }

    private UserDto buildDefaultUser() {

        return new UserDto(
                "Ivan",
                "Ivanovich",
                "Ivanov",
                41,
                "mail@mail.ru",
                new Date()
        );
    }
}
