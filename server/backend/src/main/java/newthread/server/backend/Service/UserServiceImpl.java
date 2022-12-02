package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.User;
import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.UserAlreadyExists;
import newthread.server.backend.Mapper.UserMapper;
import newthread.server.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Override
    public boolean registration(UserDto userDto) {
        try {
            userRepository.save(userMapper.modelToDto(userDto));
            return true;
        } catch (Exception e) {
            throw new UserAlreadyExists("UserAlreadyExists");
        }
    }

    @Override
    public boolean login(UserDto userDto) {
        User user = userRepository.findFirstByEmailOrLogin(userDto.getEmail(), userDto.getLogin());
        if (user.getPassword().equals(userDto.getPassword())) {
            return true;
        } else {
            throw new InvalidData("InvalidData");
        }
    }
}
