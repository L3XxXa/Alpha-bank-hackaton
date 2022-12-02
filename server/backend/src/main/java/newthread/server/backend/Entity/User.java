package newthread.server.backend.Entity;

import javax.persistence.*;
import java.awt.Point;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String email;
    String password;
    Point lastGeo;
}
