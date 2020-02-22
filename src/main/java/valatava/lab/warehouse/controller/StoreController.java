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
import valatava.lab.warehouse.service.StoreService;
import valatava.lab.warehouse.service.dto.StoreDTO;
import valatava.lab.warehouse.service.mapper.StoreMapper;

/**
 * REST controller for managing stores.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/model/store")
public class StoreController {

    private final StoreService storeService;
    private final StoreMapper storeMapper;

    public StoreController(StoreService storeService, StoreMapper storeMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
    }

    @GetMapping
    public List<StoreDTO> getAllCustomer() {
        return storeMapper.toDTOs(storeService.findAllStore());
    }

    @GetMapping("/{id}")
    public StoreDTO getCar(@PathVariable Long id) {
        return storeMapper.toDTO(storeService.findStore(id));
    }

    @PostMapping
    public void saveCar(@RequestBody StoreDTO storeDTO) throws CreatedEntityIdException {
        if (storeDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        storeService.addStore(storeMapper.toEntity(storeDTO));
    }

    @PutMapping
    public void updateCar(@RequestBody StoreDTO storeDTO) throws UpdatedEntityIdException {
        if (storeDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        storeService.addStore(storeMapper.toEntity(storeDTO));
    }
}
