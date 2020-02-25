package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Customer;
import valatava.lab.warehouse.service.dto.CustomerDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface CustomerMapper {

    List<CustomerDTO> toDTOs(List<Customer> customers);

    CustomerDTO toDTO(Customer customer);

    Customer toEntity(CustomerDTO customerDTO);
}
