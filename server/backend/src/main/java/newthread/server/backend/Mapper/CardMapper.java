package newthread.server.backend.Mapper;

import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Entity.Card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CardMapper {


    public CardDto modelToDto(Card card) {
        CardDto dto = new CardDto();
        dto.setId(card.getId());
        dto.setNumber(card.getNumber());
        dto.setName(card.getName());
        dto.setPriority(card.getPriority());
        dto.setDistanceToNearest(card.getDistanceToNearest());
        dto.setUserId(card.getUserId());
        return dto;
    }

    public List<CardDto> modelListToDto(Iterable<Card> cards) {
        List<CardDto> dtos = new ArrayList<>();
        for (Card card : cards) {
            dtos.add(modelToDto(card));
        }
        return dtos;
    }

    public Card dtoToModel(CardDto dto) {
        UserMapper userMapper = new UserMapper();
        Card card = new Card();
        card.setId(dto.getId());
        card.setName(dto.getName());
        card.setNumber(dto.getNumber());
        card.setDistanceToNearest(dto.getDistanceToNearest());
        card.setUserId(dto.getUserId());
        card.setPriority(dto.getPriority());
        return card;
    }

    public List<Card> dtoListToModel(Iterable<CardDto> dtos) {
        List<Card> cards = new ArrayList<>();
        for (CardDto dto : dtos) {
            cards.add(dtoToModel(dto));
        }
        return cards;
    }
}
