package newthread.server.backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    Long id;
    String cardName;
    String cardNumber;
    String cardImage;
}