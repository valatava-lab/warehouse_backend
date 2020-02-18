package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Product;

/**
 * Spring Data JPA repository for the {@link Product} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
}
