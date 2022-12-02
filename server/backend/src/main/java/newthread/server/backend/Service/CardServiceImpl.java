package newthread.server.backend.Service;

import newthread.server.backend.Repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class CardServiceImpl implements CardService{
    @Autowired
    CardRepository cardRepository;
}
