package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;

public interface UserService {
    boolean registration(UserDto userDto);
    boolean login(UserDto userDto);
}
