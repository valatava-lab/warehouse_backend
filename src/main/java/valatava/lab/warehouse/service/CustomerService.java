package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.model.Customer;
import valatava.lab.warehouse.repository.CustomerRepository;

/**
 * Service class for managing customers.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void save(Customer customer) {
        customerRepository.save(customer);
    }

    public Customer findCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
