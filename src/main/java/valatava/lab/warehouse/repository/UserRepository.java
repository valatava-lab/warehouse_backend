package valatava.lab.warehouse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String login);

    Optional<User> findByEmail(String email);

    Optional<User> findByActivationKey(String key);
}
