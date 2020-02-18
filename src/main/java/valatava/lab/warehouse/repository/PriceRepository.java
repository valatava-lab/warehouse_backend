package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Price;

/**
 * Spring Data JPA repository for the {@link Price} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface PriceRepository extends JpaRepository<Price, Long> {
}
