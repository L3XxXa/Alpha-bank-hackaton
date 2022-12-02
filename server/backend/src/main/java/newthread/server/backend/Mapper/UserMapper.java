package newthread.server.backend.Mapper;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User modelToDto(UserDto userDto){
        User user = new User();
        user.setLogin(userDto.getLogin());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }
}
