package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Customer;
import valatava.lab.warehouse.service.dto.CustomerDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface CustomerMapper {

    Customer toEntity(CustomerDTO customerDTO);

    CustomerDTO toDTO(Customer customer);

    List<CustomerDTO> toDTOs(List<Customer> customers);
}
