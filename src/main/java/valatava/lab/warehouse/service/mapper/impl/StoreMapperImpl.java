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

    private final CarService carService;
    private final CarMapper carMapper;
    private final CustomerService customerService;
    private final CustomerMapper customerMapper;
    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public StoreMapperImpl(CarService carService, CarMapper carMapper, CustomerService customerService,
                           CustomerMapper customerMapper, ItemService itemService, ItemMapper itemMapper) {
        this.carService = carService;
        this.carMapper = carMapper;
        this.customerService = customerService;
        this.customerMapper = customerMapper;
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @Override
    public List<StoreDTO> toDTOs(List<Store> stores) {
        return stores.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public StoreDTO toDTO(Store store) {
        StoreDTO storeDTO = new StoreDTO();
        storeDTO.setId(store.getId());
        storeDTO.setCar(carMapper.toDTO(store.getCar()));
        storeDTO.setCustomer(customerMapper.toDTO(store.getCustomer()));
        storeDTO.setItem(itemMapper.toDTO(store.getItem()));
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
    public Store toEntity(StoreDTO storeDTO) {
        Store store = new Store();
        store.setId(storeDTO.getId());
        store.setCar(carService.findCar(storeDTO.getCar().getId()));
        store.setCustomer(customerService.findCustomer(storeDTO.getCustomer().getId()));
        store.setItem(itemService.findItem(storeDTO.getItem().getId()));
        store.setYearFrom(storeDTO.getYearFrom());
        store.setYearTo(storeDTO.getYearTo());
        store.setCode(storeDTO.getCode());
        store.setDescription(storeDTO.getDescription());
        store.setBridge(storeDTO.isBridge());
        store.setAmount(storeDTO.getAmount());
        store.setPrice(storeDTO.getPrice());
        return store;
    }
}
