package valatava.lab.warehouse.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Customer;
import valatava.lab.warehouse.service.dto.CustomerDTO;
import valatava.lab.warehouse.service.mapper.CustomerMapper;

/**
 * Mapper for the entity {@link Customer} and its DTO called {@link CustomerDTO}.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class CustomerMapperImp implements CustomerMapper {

    @Override
    public List<CustomerDTO> toDTOs(List<Customer> customers) {
        return customers.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CustomerDTO toDTO(Customer customer) {
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(customer.getId());
        customerDTO.setDescription(customer.getDescription());
        return customerDTO;
    }

    @Override
    public Customer toEntity(CustomerDTO customerDTO) {
        Customer customer = new Customer();
        customer.setId(customerDTO.getId());
        customer.setDescription(customerDTO.getDescription());
        return customer;
    }
}
