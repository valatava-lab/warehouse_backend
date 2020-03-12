package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Category;

/**
 * Spring Data JPA repository for the {@link Category} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
