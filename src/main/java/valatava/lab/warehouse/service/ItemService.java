package valatava.lab.warehouse.service;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import valatava.lab.warehouse.model.Item;
import valatava.lab.warehouse.repository.ItemRepository;

/**
 * Service class for managing items.
 *
 * @author Yuriy Govorushkin
 */
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public void save(Item item) {
        itemRepository.save(item);
    }

    public Item findItem(Long id) {
        return itemRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public List<Item> findAll() {
        return itemRepository.findAll();
    }
}
