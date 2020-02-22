package valatava.lab.warehouse.service.dto;

import javax.validation.constraints.Size;
import lombok.Data;

/**
 * A DTO representing a store.
 *
 * @author Yuriy Govorushkin
 */
@Data
public class StoreDTO {

    private Long id;
    private ItemDTO item;
    private CustomerDTO customer;
    private CarDTO car;

    @Size(max = 4, min = 4)
    private Long yearFrom;

    @Size(max = 4, min = 4)
    private Long yearTo;

    private String code;
    private String description;
    private boolean bridge;
    private Long amount;
    private Long price;
}
