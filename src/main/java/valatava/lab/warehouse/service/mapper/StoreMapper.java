package valatava.lab.warehouse.service.mapper;

import java.util.List;
import valatava.lab.warehouse.model.Store;
import valatava.lab.warehouse.service.dto.StoreDTO;

/**
 * @author Yuriy Govorushkin
 */
public interface StoreMapper {

    List<StoreDTO> toDTOs(List<Store> stores);

    StoreDTO toDTO(Store store);

    Store toEntity(StoreDTO storeDTO);
}
