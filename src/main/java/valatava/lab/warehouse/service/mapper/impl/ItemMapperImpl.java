package valatava.lab.warehouse.service.mapper.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import valatava.lab.warehouse.model.Item;
import valatava.lab.warehouse.service.dto.ItemDTO;
import valatava.lab.warehouse.service.mapper.ItemMapper;

/**
 * Mapper for the entity {@link Item} and its DTO called {@link ItemDTO}.
 *
 * @author Yuriy Govorushkin
 */
@Service
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDTO itemDTO) {
        Item item = new Item();
        item.setId(itemDTO.getId());
        item.setDescription(itemDTO.getDescription());
        return item;
    }

    @Override
    public ItemDTO toDTO(Item item) {
        ItemDTO itemDTO = new ItemDTO();
        itemDTO.setId(item.getId());
        itemDTO.setDescription(item.getDescription());
        return itemDTO;
    }

    @Override
    public List<ItemDTO> toDTOs(List<Item> items) {
        return items.stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }
}
