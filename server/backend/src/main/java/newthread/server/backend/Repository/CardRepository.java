package newthread.server.backend.Repository;

import newthread.server.backend.Entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository

public interface CardRepository extends CrudRepository<Card, Long> {
}
