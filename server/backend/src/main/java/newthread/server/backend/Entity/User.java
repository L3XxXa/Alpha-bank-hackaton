package newthread.server.backend.Entity;

import javax.persistence.*;
import java.awt.Point;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String login;
    private String email;
    private String password;
    private Point lastGeo;
}
