package newthread.server.backend.Mapper;

import newthread.server.backend.Dto.CardDto;
import newthread.server.backend.Entity.Card;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class CardMapper {
    public CardDto modelToDto(Card card) {
        CardDto dto = new CardDto();
        dto.setId(card.getId());
        dto.setImage(card.getImage());
        dto.setNumber(card.getNumber());
        dto.setName(card.getName());
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
        Card card = new Card();
        card.setId(dto.getId());
        card.setName(dto.getNumber());
        card.setImage(dto.getImage());
        card.setNumber(dto.getNumber());
        return card;
    }
}
