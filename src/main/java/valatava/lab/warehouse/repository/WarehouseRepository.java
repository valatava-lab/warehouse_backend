package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Warehouse;

/**
 * Spring Data JPA repository for the {@link Warehouse} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface WarehouseRepository extends JpaRepository<Warehouse, Long> {
}
