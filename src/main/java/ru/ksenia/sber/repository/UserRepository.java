package ru.ksenia.sber.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import ru.ksenia.sber.dto.UserDto;

import javax.xml.ws.WebServiceException;
import java.io.InputStream;
import java.util.Optional;

/**
 * Репозиторий для работы с данными пользователя
 */
@Repository
public class UserRepository {
    private static final ObjectMapper mapper = new ObjectMapper();

    /**
     * Получение пользовательских данных по id
     *
     * @param userId идентификатор пользователя
     * @return дто пользователя
     */
    public Optional<UserDto> getUserDataById(Long userId) {

        try (InputStream fileStream =
                     getClass().getResourceAsStream(String.format("/json/user_%d.json", userId))
        ) {
            return Optional.of(mapper.readValue(fileStream, UserDto.class));
        } catch (Exception e) {
            throw new WebServiceException("" + e.getMessage());
        }
    }
}
