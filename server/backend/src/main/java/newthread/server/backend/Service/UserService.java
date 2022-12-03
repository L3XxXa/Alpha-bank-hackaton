package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;

import java.util.List;

public interface UserService {
    boolean registration(UserDto userDto);

    boolean login(UserDto userDto);

    List<UserDto> getUsers();

    UserDto getUserById(Long id);

    UserDto getUserByLogin(String login);

    UserDto getUserByEmail(String email);

    Boolean deleteUser(Long id);
}
