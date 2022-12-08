package newthread.server.backend.Service;

import net.bytebuddy.utility.nullability.UnknownNull;
import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Dto.UserDto;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Mapper.CardMapper;
import newthread.server.backend.Repository.CardRepository;
import newthread.server.backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardMapper mapper;

    @Autowired
    UserRepository userRepository;
    @Override
    public boolean addCard(CardDto dto) {
        cardRepository.save(mapper.dtoToModel(dto));
        return true;
    }

    @Override
    public List<CardDto> getAllCards() {
        return mapper.modelListToDto(cardRepository.findAllByOrderByPriorityAsc());
    }

    @Override
    public boolean deleteCard(Long id) {
        try {
            cardRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            throw new NotFound("Not Found");
        }

    }
}
