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
        dto.setCardImage(card.getImage());
        dto.setCardNumber(card.getNumber());
        dto.setCardName(card.getName());
        return dto;
    }

    public List<CardDto> modelListToDto(List<Card> cards) {
        List<CardDto> dtos = new ArrayList<>();
        for (Card card : cards) {
            dtos.add(modelToDto(card));
        }
        return dtos;
    }
}
