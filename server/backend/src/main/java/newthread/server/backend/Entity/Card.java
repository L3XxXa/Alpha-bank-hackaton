package newthread.server.backend.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "cards")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cardName;
    String cardImage;
    String cardNumber;
    @OneToOne
    User user;
}
