package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Car;

/**
 * Spring Data JPA repository for the {@link Car} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface CarRepository extends JpaRepository<Car, Long> {
}
