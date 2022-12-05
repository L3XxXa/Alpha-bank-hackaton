package newthread.server.backend.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDto {
    private Long id;
    private String name;
    private String number;
    private String image;

    private Integer priority;
}
