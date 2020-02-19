package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Item;

/**
 * Spring Data JPA repository for the {@link Item} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
}
