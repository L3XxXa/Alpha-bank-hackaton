package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.User;
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
            return false;
        }
    }

    @Override
    public boolean login(UserDto userDto) {
        User user = userRepository.findFirstByEmailOrLogin(userDto.getLogin(), userDto.getEmail());
        return user.getPassword().equals(userDto.getPassword());
    }
}
