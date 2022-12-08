package newthread.server.backend.Dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

@Getter
@Setter
public class CardDto {
    private Long id;
    private String name;
    private String number;
    @Value("${some.key:0}")
    private Integer priority;
    private Double distanceToNearest;
    private Long userId;
}
