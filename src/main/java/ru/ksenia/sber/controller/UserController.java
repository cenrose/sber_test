package ru.ksenia.sber.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.ksenia.sber.dto.UserDto;
import ru.ksenia.sber.service.UserService;

/**
 * Пользовательский контроллер
 */
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/getById/{id}")
    public UserDto getUser(@PathVariable(value = "id") Long userId) {
        return userService.getUserDataById(userId);
    }
}
