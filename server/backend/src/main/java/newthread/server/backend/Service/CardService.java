package newthread.server.backend.Service;

import newthread.server.backend.Dto.CardDto;

import java.util.List;

public interface CardService {
    boolean addCard(CardDto dto);

    List<CardDto> getAllCards();

    boolean deleteCard(Long id);
}
