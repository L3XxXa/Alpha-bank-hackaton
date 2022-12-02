package newthread.server.backend.Repository;

import newthread.server.backend.Entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User,Long> {
}
