package valatava.lab.warehouse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.User;

/**
 * Spring Data JPA repository for the {@link User} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);

    Optional<User> findByActivationKey(String key);
}
