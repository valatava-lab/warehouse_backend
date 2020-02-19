package valatava.lab.warehouse.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import valatava.lab.warehouse.model.Customer;

/**
 * Spring Data JPA repository for the {@link Customer} entity.
 *
 * @author Yuriy Govorushkin
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {
}
