package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Item;
import valatava.lab.warehouse.service.dto.ItemDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface ItemMapper {

    Item toEntity(ItemDTO itemDTO);

    ItemDTO toDTO(Item item);

    List<ItemDTO> toDTOs(List<Item> items);
}
