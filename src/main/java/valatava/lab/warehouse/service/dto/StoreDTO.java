package valatava.lab.warehouse.service.dto;

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
    private Long yearFrom;
    private Long yearTo;
    private String code;
    private String description;
    private boolean bridge;
    private Long amount;
    private Long price;
}
