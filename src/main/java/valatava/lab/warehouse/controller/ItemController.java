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
 * REST controller for managing the items.
 *
 * @author Yuriy Govorushkin
 */
@RestController
@RequestMapping("/api/items")
public class ItemController {

    private final ItemService itemService;
    private final ItemMapper itemMapper;

    public ItemController(ItemService itemService, ItemMapper itemMapper) {
        this.itemService = itemService;
        this.itemMapper = itemMapper;
    }

    @GetMapping
    public List<ItemDTO> getAll() {
        return itemMapper.toDTOs(itemService.findAll());
    }

    @GetMapping("{id}")
    public ItemDTO getItem(@PathVariable Long id) {
        return itemMapper.toDTO(itemService.findItem(id));
    }

    @PostMapping
    public void saveItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO.getId() != null) {
            throw new CreatedEntityIdException();
        }
        itemService.save(itemMapper.toEntity(itemDTO));
    }

    @PutMapping
    public void updateItem(@RequestBody ItemDTO itemDTO) {
        if (itemDTO.getId() == null) {
            throw new UpdatedEntityIdException();
        }
        itemService.save(itemMapper.toEntity(itemDTO));
    }
}
