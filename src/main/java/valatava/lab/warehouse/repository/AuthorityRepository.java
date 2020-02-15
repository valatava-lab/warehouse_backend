package valatava.lab.warehouse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(String name);
}
