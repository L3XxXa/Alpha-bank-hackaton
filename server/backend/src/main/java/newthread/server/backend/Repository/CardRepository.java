package newthread.server.backend.Repository;

import newthread.server.backend.Entity.Card;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CardRepository extends CrudRepository<Card, Long> {
    Card findFirstById(Long id);
    List<Card> findAllByOrderByPriorityAsc();
}
