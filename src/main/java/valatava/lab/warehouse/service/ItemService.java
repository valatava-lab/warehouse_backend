package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Item;
import valatava.lab.warehouse.repository.ItemRepository;

/**
 * Service class for managing item.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void addItem(Item item) {
        itemRepository.save(item);
    }

    public List<Item> findAllItem() {
        return itemRepository.findAll();
    }

    public Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }
}
