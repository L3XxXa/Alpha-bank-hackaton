package newthread.server.backend.Dto;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;


@Getter
@Setter
public class UserDto {
    Long id;
    String login;
    String email;
    String password;
    Point lastGeo;
}
