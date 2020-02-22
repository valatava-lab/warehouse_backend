package valatava.lab.warehouse.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Store;
import valatava.lab.warehouse.service.CarService;
import valatava.lab.warehouse.service.CustomerService;
import valatava.lab.warehouse.service.ItemService;
import valatava.lab.warehouse.service.dto.StoreDTO;
import valatava.lab.warehouse.service.mapper.CarMapper;
import valatava.lab.warehouse.service.mapper.CustomerMapper;
import valatava.lab.warehouse.service.mapper.ItemMapper;
import valatava.lab.warehouse.service.mapper.StoreMapper;

/**
 * Mapper for the entity {@link Store} and its DTO called {@link StoreDTO}.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class StoreMapperImpl implements StoreMapper {

    private final ItemService itemService;
    private final ItemMapper itemMapper;
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final CarService carService;
    private final CarMapper carMapper;

    public StoreMapperImpl(ItemService itemService, ItemMapper itemMapper, CustomerService customerService,
                           CustomerMapper customerMapper, CarService carService, CarMapper carMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.carService = carService;
        this.carMapper = carMapper;
    }

    @Override
    public Store toEntity(StoreDTO storeDTO) {
        Store store = new Store();
        store.setId(storeDTO.getId());
        store.setItem(itemService.findItem(storeDTO.getItem().getId()));
        store.setCustomer(customerService.findCar(storeDTO.getCustomer().getId()));
        store.setCar(carService.findCar(storeDTO.getCar().getId()));
        store.setYearFrom(storeDTO.getYearFrom());
        store.setYearTo(storeDTO.getYearTo());
        store.setCode(storeDTO.getCode());
        store.setDescription(storeDTO.getDescription());
        store.setBridge(storeDTO.isBridge());
        store.setAmount(storeDTO.getAmount());
        store.setPrice(storeDTO.getPrice());
        return store;
    }

    @Override
    public StoreDTO toDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setItem(itemMapper.toDTO(store.getItem()));
        storeDTO.setCustomer(customerMapper.toDTO(store.getCustomer()));
        storeDTO.setCar(carMapper.toDTO(store.getCar()));
        storeDTO.setYearFrom(store.getYearFrom());
        storeDTO.setYearTo(store.getYearTo());
        storeDTO.setCode(store.getCode());
        storeDTO.setDescription(store.getDescription());
        storeDTO.setBridge(store.isBridge());
        storeDTO.setAmount(store.getAmount());
        storeDTO.setPrice(store.getPrice());
        return storeDTO;
    }

    @Override
    public List<StoreDTO> toDTOs(List<Store> stores) {
        return stores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
