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
import valatava.lab.warehouse.service.ItemService;
import valatava.lab.warehouse.service.dto.ItemDTO;
import valatava.lab.warehouse.service.mapper.ItemMapper;

/**
 * REST controller for managing items.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/model/item")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping
    public List<ItemDTO> getAllCustomer() {
        return itemMapper.toDTOs(itemService.findAllItem());
    }

    @GetMapping("/{id}")
    public ItemDTO getCar(@PathVariable Long id) {
        return itemMapper.toDTO(itemService.findItem(id));
    }

    @PostMapping
    public void saveCar(@RequestBody ItemDTO itemDTO) throws CreatedEntityIdException {
        if (itemDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        itemService.addItem(itemMapper.toEntity(itemDTO));
    }

    @PutMapping
    public void updateCar(@RequestBody ItemDTO itemDTO) throws UpdatedEntityIdException {
        if (itemDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        itemService.addItem(itemMapper.toEntity(itemDTO));
    }
}
