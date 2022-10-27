package ru.ksenia.sber.service;

import ru.ksenia.sber.dto.UserDto;

/**
 * Сервис для работы с пользователями
 */
public interface UserService {

    /**
     * Получение пользовательских данных по id
     *
     * @param userId идентификатор пользователя
     * @return дто пользователя
     */
    UserDto getUserDataById(Long userId);
}
