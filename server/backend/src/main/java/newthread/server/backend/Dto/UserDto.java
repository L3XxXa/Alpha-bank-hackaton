package newthread.server.backend.Dto;

import lombok.Getter;
import lombok.Setter;
import newthread.server.backend.Entity.Card;

import java.util.List;


@Getter
@Setter
public class UserDto {
    Long id;
    String login;
    String email;
    String password;
    Double lastLat;
    Double lastLon;
    List<CardDto> cards;
}
