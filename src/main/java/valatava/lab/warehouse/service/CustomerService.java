package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Customer;
import valatava.lab.warehouse.repository.CustomerRepository;

/**
 * Service class for managing customer.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public void addCar(Customer customer) {
        customerRepository.save(customer);
    }

    public List<Customer> findAllCustomer() {
        return customerRepository.findAll();
    }

    public Customer findCar(Long id) {
        return customerRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
