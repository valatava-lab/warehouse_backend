package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Manufacturer;

/**
 * Spring Data JPA repository for the {@link Manufacturer} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface ManufacturerRepository extends JpaRepository<Manufacturer, Long> {
}
