package newthread.server.backend.Service;

import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Entity.Card;
import newthread.server.backend.Mapper.CardMapper;
import newthread.server.backend.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CardServiceImpl implements CardService {
    @Autowired
    CardRepository cardRepository;

    @Autowired
    CardMapper mapper;

    @Override
    public boolean addCard(CardDto dto) {
        Card card = mapper.dtoToModel(dto);
        cardRepository.save(card);
        return true;
    }
}