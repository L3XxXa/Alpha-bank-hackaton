package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.User;
import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Exception.UserAlreadyExists;
import newthread.server.backend.Mapper.CardMapper;
import newthread.server.backend.Mapper.UserMapper;
import newthread.server.backend.Repository.UserRepository;
import newthread.server.backend.Utils.ApiConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Autowired
    CardMapper cardMapper;

    @Override
    public boolean registration(UserDto userDto) {
        try {
            userRepository.save(userMapper.dtoToModel(userDto));
            return true;
        } catch (Exception e) {
            throw new UserAlreadyExists("UserAlreadyExists");
        }
    }

    @Override
    public boolean login(UserDto userDto) {
        User user = userRepository.findFirstByEmail(userDto.getEmail());
        if (user.getPassword().equals(userDto.getPassword())) {
            return true;
        } else {
            throw new InvalidData("InvalidData");
        }
    }

    @Override
    public List<UserDto> getUsers() {
        return userMapper.modelListToDto(userRepository.findAll());

    }

    @Override
    public UserDto getUserById(Long id) {
        try {
            return userMapper.modelToDto(userRepository.findById(id).orElseThrow());
        } catch (Exception e) {
            throw new NotFound("Not found");
        }
    }

    @Override
    public Boolean deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new NotFound("Not found");
        }
    }

    public boolean updateUser(UserDto userDto) {
        userRepository.save(userMapper.dtoToModel(userDto));
        return true;
    }

    public Boolean refreshCards(UserDto userDto) throws IOException {
        var cards = cardMapper.dtoListToModel(userDto.getCards());
        Point2D userCoordinate = new Point2D.Double(userDto.getLastLat(), userDto.getLastLon());
        ApiConnector connector = new ApiConnector();
        connector.findPoints(cards, userCoordinate);
        return true;
    }

}
