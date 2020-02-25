package valatava.lab.warehouse.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valatava.lab.warehouse.exeption.CreatedEntityIdException;
import valatava.lab.warehouse.exeption.UpdatedEntityIdException;
import valatava.lab.warehouse.service.CustomerService;
import valatava.lab.warehouse.service.dto.CustomerDTO;
import valatava.lab.warehouse.service.mapper.CustomerMapper;

/**
 * REST controller for managing the customers.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {

    private final CustomerService customerService;
    private final CustomerMapper customerMapper;

    public CustomerController(CustomerService customerService, CustomerMapper customerMapper) {
        this.customerService = customerService;
        this.customerMapper = customerMapper;
    }

    @GetMapping
    public List<CustomerDTO> getAll() {
        return customerMapper.toDTOs(customerService.findAll());
    }

    @GetMapping("{id}")
    public CustomerDTO getCustomer(@PathVariable Long id) {
        return customerMapper.toDTO(customerService.findCustomer(id));
    }

    @PostMapping
    public void saveCar(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        customerService.save(customerMapper.toEntity(customerDTO));
    }

    @PutMapping
    public void updateCar(@RequestBody CustomerDTO customerDTO) {
        if (customerDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        customerService.save(customerMapper.toEntity(customerDTO));
    }
}
