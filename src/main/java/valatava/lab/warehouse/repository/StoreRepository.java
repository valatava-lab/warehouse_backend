package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Store;

/**
 * Spring Data JPA repository for the {@link Store} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface StoreRepository extends JpaRepository<Store, Long> {
}
