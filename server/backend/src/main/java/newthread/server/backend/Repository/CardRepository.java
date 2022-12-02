package newthread.server.backend.Repository;

import newthread.server.backend.Entity.Card;
import org.springframework.data.repository.CrudRepository;

public interface CardRepository extends CrudRepository<Card, Long> {
}
