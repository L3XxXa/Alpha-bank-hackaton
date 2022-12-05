package newthread.server.backend.Service;

import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Entity.Card;
import newthread.server.backend.Exception.NotFound;
import newthread.server.backend.Mapper.CardMapper;
import newthread.server.backend.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardMapper mapper;

    @Override
    public boolean addCard(CardDto dto) {
        cardRepository.save(mapper.dtoToModel(dto));
        return true;
    }

    @Override
    public List<CardDto> getAllCards() {
        return mapper.modelListToDto(cardRepository.findAll());
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
