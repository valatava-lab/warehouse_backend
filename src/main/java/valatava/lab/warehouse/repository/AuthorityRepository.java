package valatava.lab.warehouse.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Authority;

public interface AuthorityRepository extends JpaRepository<Authority, Long> {

    Optional<Authority> findByName(String name);
}
