package newthread.server.backend.Service;

import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Entity.Card;
import newthread.server.backend.Entity.User;
import newthread.server.backend.Exception.InvalidData;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Exception.UserAlreadyExists;
import newthread.server.backend.Mapper.CardMapper;
import newthread.server.backend.Mapper.UserMapper;
import newthread.server.backend.Repository.CardRepository;
import newthread.server.backend.Repository.UserRepository;
import newthread.server.backend.Utils.ApiConnector;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    @Autowired
    CardMapper cardMapper;

    @Autowired
    CardRepository cardRepository;

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
        String password;
        try {
            User user = userRepository.findFirstByEmail(userDto.getEmail());
            password = user.getPassword();
        } catch (Exception e) {
            throw new NotFound("Not found");
        }
        if (password.equals(userDto.getPassword())) {
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

    public Boolean refreshCards(Long id) throws IOException {
        User user = userRepository.findById(id).orElse(null);
        var cards = user.getCards();
        Point2D userCoordinate = new Point2D.Double(user.getLastLat(), user.getLastLon());
        ApiConnector connector = new ApiConnector();
        List<Double> results = new ArrayList<>();
        var map =
                connector.findPoints(cards, userCoordinate, results);
        for (int i = 0; i < results.size(); i++) {
            Long curId = map.get(results.get(i));
            Card curCard = cardRepository.findFirstById(curId);
            curCard.setPriority(i);
            curCard.setDistanceToNearest(results.get(i));
            cardRepository.save(curCard);
        }
        return true;
    }

}
