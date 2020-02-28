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
 * REST controller for managing the stores.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/api/stores")
public class StoreController {

    private final StoreService storeService;
    private final StoreMapper storeMapper;

    public StoreController(StoreService storeService, StoreMapper storeMapper) {
        this.storeService = storeService;
        this.storeMapper = storeMapper;
    }

    @GetMapping
    public List<StoreDTO> getAll() {
        return storeMapper.toDTOs(storeService.findAll());
    }

    @GetMapping("{id}")
    public StoreDTO getStore(@PathVariable Long id) {
        return storeMapper.toDTO(storeService.findStore(id));
    }

    @PostMapping
    public void saveStore(@RequestBody StoreDTO storeDTO) {
        if (storeDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        storeService.save(storeMapper.toEntity(storeDTO));
    }

    @PutMapping
    public void updateStore(@RequestBody StoreDTO storeDTO) {
        if (storeDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        storeService.save(storeMapper.toEntity(storeDTO));
    }
}
