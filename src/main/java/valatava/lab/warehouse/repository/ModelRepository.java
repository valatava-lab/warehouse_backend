package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Model;

/**
 * Spring Data JPA repository for the {@link Model} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface ModelRepository extends JpaRepository<Model, Long> {
}
